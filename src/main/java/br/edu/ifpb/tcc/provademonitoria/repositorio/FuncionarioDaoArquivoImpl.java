/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.provademonitoria.repositorio;

import br.edu.ifpb.tcc.provademonitoria.entidades.Funcionario;
import br.edu.ifpb.tcc.provademonitoria.repositorio.Dao;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class FuncionarioDaoArquivoImpl implements Dao<Funcionario> {

    @Override
    public boolean deletar(Funcionario e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Funcionario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean salvar(Funcionario e) {
        try {
            ObjectOutputStream Out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("dados")));
            Out.writeObject(e);
            Out.close();
        } catch (IOException ex) {
            Logger.getLogger(FuncionarioDaoArquivoImpl.class.getName()).log(Level.SEVERE,
                    null, ex);
            return false;
        }
        return true;
    }
   
}
