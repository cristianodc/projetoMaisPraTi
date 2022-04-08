/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maisprati.model;

import java.util.Date;
import maisprati.util.Util;

/**
 *
 * @author Cristiano
 * Classe que represente uma entidade 
 */
public class Pessoa {
    private String nome;
    private String fone;
    private Date nascimento;
    private Date cadastro;
    private Date alteracaoCad;

    public Pessoa() {
    }

    public Pessoa(String nome, String fone, Date nascimento, Date cadastro, Date alteracaoCad) {
        this.nome = nome;
        this.fone = fone;
        this.nascimento = nascimento;
        this.cadastro = cadastro;
        this.alteracaoCad = alteracaoCad;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the fone
     */
    public String getFone() {
        return fone;
    }

    /**
     * @return the nascimento
     */
    public Date getNascimento() {
        return nascimento;
    }

    /**
     * @return the cadastro
     */
    public Date getCadastro() {
        return cadastro;
    }

    /**
     * @return the alteracaoCad
     */
    public Date getAlteracaoCad() {
        return alteracaoCad;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @param cadastro the cadastro to set
     */
    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    /**
     * @param alteracaoCad the alteracaoCad to set
     */
    public void setAlteracaoCad(Date alteracaoCad) {
        this.alteracaoCad = alteracaoCad;
    }

    @Override
    public String toString() {
        
        return "Nome: "+ this.getNome()+"\n"+"Telefone :"+this.getFone()+"\n"+"Data Nascimento : "
                +Util.dateTostring(this.getNascimento())+"\n"+"Data Cadastro :"+Util.dateTostring(this.getCadastro())+"\n"+"Data Alteração Cad :"+
        		 Util.dateTostring(this.getAlteracaoCad());
    }
    
    
    
    
    
}
