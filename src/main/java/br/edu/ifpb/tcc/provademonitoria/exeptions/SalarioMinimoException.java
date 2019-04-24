/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.provademonitoria.exeptions;

import sun.awt.CausedFocusEvent;

/**
 *
 * @author jose
 */
public class SalarioMinimoException extends Exception{
    
  public SalarioMinimoException salarioMinimo( double Salario ){
      if(Salario<990.00)
          return new SalarioMinimoException();
      return null;
  }

    @Override
    public String getMessage() {
        return "O salário do funcionário não pode ser inferior ao minimo ";
    }
    
}
