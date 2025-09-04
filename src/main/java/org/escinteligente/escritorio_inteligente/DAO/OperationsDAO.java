package org.escinteligente.escritorio_inteligente.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface OperationsDAO<T> {

    DataBase DATABASE = DataBase.getInstance();

    default PreparedStatement getPreparatedStatement (String sql) throws SQLException {
        try (PreparedStatement preparedStatement =  DATABASE.getConnection().prepareStatement(sql)){
            return preparedStatement;
        }
    }

    Optional<List<T>> listAll ();

    Optional<T> listById (int id);

    void create ();

    void update ();

    void deleteById (int id);
}
