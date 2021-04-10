package com.github.kodomo.mallysmith.government.database.repository.publicservant;

import com.github.kodomo.mallysmith.government.database.orm.MysqlConnector;
import com.github.kodomo.mallysmith.government.database.orm.Repository;

public class PublicServantRepository {

    private final Repository repository = MysqlConnector.getInstance().getRepository();

    public PublicServant findById(int id) {
        try {
            return repository.findOne(
                    String.format("select * from tbl_public_servant where id = %d", id),
                    PublicServant.class
            );
        } catch (Exception ignored) {}
        return null;
    }

}
