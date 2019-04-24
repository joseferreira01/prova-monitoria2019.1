/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.provademonitoria.entidades;

import br.edu.ifpb.tcc.provademonitoria.exeptions.SalarioMinimoException;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author jose
 */
public class Funcionario implements Serializable {

    private String CPF;
    private String nome;
    private LocalDate dataNasc;
    private double salario;

    public Funcionario() {
        {

        }
    }

    public Funcionario(String CPF, String nome, LocalDate dataNasc, double salario) {
        this.CPF = CPF;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.salario = salario;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

  
    

}
