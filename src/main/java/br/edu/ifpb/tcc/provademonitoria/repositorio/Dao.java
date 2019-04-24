/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.provademonitoria.repositorio;

import java.util.Set;

/**
 *
 * @author jose
 */
public interface Dao<T> {

    boolean deletar(T e);

    Set<T> listar();

    boolean salvar(T e);
    
}
