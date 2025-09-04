package org.escinteligente.escritorio_inteligente.DAO;

import java.io.Closeable;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//SINGLETON
public class DataBase implements Closeable {

    private static DataBase instance;

    private final URL dbResource;
    private File dbFile;
    private String url;
    private Connection connection;

    private DataBase (){
        this.dbResource = DataBase.class.getClassLoader().getResource("bd/dbEscritorio.db");
        try {
            if (dbResource != null){
                dbFile = new File(dbResource.toURI());
            } else {
                throw new RuntimeException("Path to BD not found");
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        if (dbFile != null){
            this.url = "jdbc:sqlite"+dbFile.getAbsolutePath();
        } else {
            throw new RuntimeException("BD file not found");
        }
    }

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
