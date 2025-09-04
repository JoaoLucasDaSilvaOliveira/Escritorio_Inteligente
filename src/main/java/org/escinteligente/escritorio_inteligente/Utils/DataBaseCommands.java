package org.escinteligente.escritorio_inteligente.Utils;

public final class DataBaseCommands {

    private DataBaseCommands (){}

    public static String selectAll(String tableName){
        return "SELECT * FROM " + tableName;
    }

}
