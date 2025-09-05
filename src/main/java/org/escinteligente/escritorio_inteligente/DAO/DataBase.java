package org.escinteligente.escritorio_inteligente.DAO;

import java.io.Closeable;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//SINGLETON
public class DataBase implements Closeable {

    private static DataBase instance;

    private final static Path PATH = Path.of(System.getProperty("user.dir")).resolve("src", "main", "resources", "BD.db");
    private final static String url = "jdbc:sqlite:"+PATH;
    private Connection connection;

    private DataBase (){}

    public static DataBase getInstance (){
        if (instance == null){
            return new DataBase();
        }
        return instance;
    }

    public Connection getConnection (){
        try {
            this.connection = DriverManager.getConnection(url);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        if (this.connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
