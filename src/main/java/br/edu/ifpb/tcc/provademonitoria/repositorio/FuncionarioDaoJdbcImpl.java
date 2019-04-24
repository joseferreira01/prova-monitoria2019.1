/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.provademonitoria.repositorio;

import br.edu.ifpb.tcc.provademonitoria.entidades.Funcionario;
import br.edu.ifpb.tcc.provademonitoria.repositorio.Dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class FuncionarioDaoJdbcImpl implements Dao<Funcionario> {

    private Connection connection;

    public FuncionarioDaoJdbcImpl() throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/banco", "postgres", "12345");
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean salvar(Funcionario e) {
         try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into funcionario(nome,CPF,dataNasc,salario) values (?,?, ?,?)");
            // Parameters start with 1
            preparedStatement.setString(1,e.getNome());
            preparedStatement.setString(2, e.getCPF());
            preparedStatement.setDate(3, Date.valueOf(e.getDataNasc()));
            preparedStatement.setDouble(4, e.getSalario());
           

            return preparedStatement.execute();

       
    }   catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    @Override
    public Set<Funcionario> listar() {
        Set<Funcionario> lista = new HashSet<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select f.nome, f.CPF, f.dataNas, f.salario ");

            while (rs.next()) {

                Funcionario f = new Funcionario(rs.getNString("CPF"), rs.getString("nome"),
                         rs.getDate("dataNas").toLocalDate(), rs.getDouble("salario"));
                lista.add(f);
                connection.close();

            }
       

        return lista;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_SET;
    }

    @Override
    public boolean deletar(Funcionario e) {
        boolean reus= false;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete funcionario where CPF=?");
            // Parameters start with 1
            preparedStatement.setString(1, e.getCPF());

              reus= preparedStatement.execute();
            connection.close();
            return reus;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reus;
    }
}
