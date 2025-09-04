package org.escinteligente.escritorio_inteligente.DAO;

import org.escinteligente.escritorio_inteligente.Model.Empresa;
import org.escinteligente.escritorio_inteligente.Utils.DataBaseCommands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpresaDAO implements OperationsDAO<Empresa>{

    private final static String TABLENAME = "EMPRESA";

    @Override
    public Optional<List<Empresa>> listAll() {
        //CRIANDO LISTA DAS EMPRESAS
        List<Empresa> empresas = new ArrayList<>();
        //CONECTANDO COM O BANCO
        try (
                PreparedStatement preparedStatement = getPreparatedStatement(DataBaseCommands.selectAll(TABLENAME));
                ResultSet result = preparedStatement.executeQuery()
        ){
            //ENQUANTO HOUVER RESULTADO:
            while (result.next()){
                //CRIAMOS NOVAS INSTANCIAS DE EMPRESA E COLOCAMOS NA LISTA
                empresas.add(new Empresa(
                        result.getInt("id"),
                        result.getString("cnpj"),
                        result.getString("nome"),
                        result.getBoolean("variaveis"),
                        result.getBoolean("temProlabore"),
                        result.getString("tipoFolha"),
                        result.getString("tipoEnvio"),
                        result.getString("nomeDono"),
                        result.getString("telefoneDono")
                ));
            }
            //CASO NÃO TENHA NADA EM NOSSA LISTA, RETORNAMOS UM OPTIONAL VAZIO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Empresa> listById(int id) {
        return null;
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void deleteById(int id) {

    }
}
