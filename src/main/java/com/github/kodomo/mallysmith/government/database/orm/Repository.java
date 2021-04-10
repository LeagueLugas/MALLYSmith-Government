package com.github.kodomo.mallysmith.government.database.orm;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Repository {

    private final Connection connection;
    private final Statement statement;

    public <T> T findOne(String query, Class<T> tClass) throws Exception {
        return findAll(query, tClass).get(0);
    }

    public <T> List<T> findAll(String query, Class<T> tClass) throws Exception {
        List<T> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String[] fieldStrings = Arrays.stream(tClass.getDeclaredFields())
                    .map(Field::getName)
                    .toArray(String[]::new);
            T entity = tClass.newInstance();
            for (String fieldString : fieldStrings) {
                Field field = entity.getClass().getDeclaredField(fieldString);
                field.setAccessible(true);
                field.set(entity, resultSet.getObject(camelToSnake(fieldString)));
            }
            list.add(entity);
        }
        return list;
    }

    public <T> T save(T entity) throws Exception {
        String[] fieldStrings = Arrays.stream(entity.getClass().getDeclaredFields())
                .map(Field::getName)
                .toArray(String[]::new);
        String tableName = camelToSnake(entity.getClass().getSimpleName());
        String tableFields = Arrays.stream(fieldStrings)
                .map(this::camelToSnake).collect(Collectors.joining(","));
        String entityFields = Arrays.stream(fieldStrings)
                .map(s -> {
                    try {
                        Object obj = entity.getClass().getDeclaredField(s).get(entity);
                        String value = obj.toString();
                        if (obj.getClass().equals(String.class)) {
                            value = "'" + value + "'";
                        }
                        return value;
                    } catch (IllegalAccessException | NoSuchFieldException ignored) {}
                    return "NULL";
                }).collect(Collectors.joining(","));
        statement.execute(String.format("insert into %s(%s) values (%s)", tableName, tableFields, entityFields));
        return entity;
    }

    private String camelToSnake(String str) {
        StringBuilder result = new StringBuilder();

        char c = str.charAt(0);
        result.append(Character.toLowerCase(c));

        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                result.append('_');
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

}
