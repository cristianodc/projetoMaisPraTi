/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maisprati.model;

import java.util.Date;

/**
 *
 * @author Cristiano
 * Classe que represetne uma entidada chamada aluno que extend a classe pessoa herdando seus campos e metodos
 */
public class Aluno  extends Pessoa{
    
    private double notaF;

    public Aluno( String nome, String fone, Date nascimento, Date cadastro, Date alteracaoCad,double notaF) {
        super(nome, fone, nascimento, cadastro, alteracaoCad);
        this.notaF = notaF;
    }

    /**
     * @return the notaF
     */
    public double getNotaF() {
        return notaF;
    }

    /**
     * @param notaF the notaF to set
     */
    public void setNotaF(double notaF) {
        this.notaF = notaF;
    }

    @Override
    public String toString() {
         
        return super.toString()+"Nota Final :"+this.getNotaF();
    }
    
    @Override
    public String cadAlterado() 
    	{
    		return super.toString()+"Nota Final :"+this.getNotaF();
    	}
    
}
