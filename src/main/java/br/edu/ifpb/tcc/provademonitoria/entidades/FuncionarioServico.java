/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.provademonitoria.entidades;

import br.edu.ifpb.tcc.provademonitoria.repositorio.Dao;
import br.edu.ifpb.tcc.provademonitoria.repositorio.FuncionarioDaoJdbcImpl;
import java.time.LocalDate;

/**
 *
 * @author jose
 */
public class FuncionarioServico {
    private Dao<Funcionario> dao;

    public FuncionarioServico() throws ClassNotFoundException {
         dao = new FuncionarioDaoJdbcImpl();
    }
    
    public boolean salvar(String CPF, String nome, LocalDate dataNasc, double salario){
        Funcionario funcionario = new Funcionario(CPF, nome, dataNasc, salario);
     return dao.salvar(funcionario);
}
    
    
}
