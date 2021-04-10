package com.github.kodomo.mallysmith.government.database.orm;

import java.sql.*;

public class MysqlConnector {

    private static MysqlConnector instance = new MysqlConnector();
    private static final String MYSQL_URL = System.getenv("MYSQL_URL");

    private Connection connection = null;
    private Statement statement = null;
    private Repository repository;

    private MysqlConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(MYSQL_URL);
            statement = connection.createStatement();
            repository = new Repository(connection, statement);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static MysqlConnector getInstance() {
        if (instance == null) instance = new MysqlConnector();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public Repository getRepository() {
        return repository;
    }

}
