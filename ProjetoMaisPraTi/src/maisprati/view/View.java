/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maisprati.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import maisprati.model.Aluno;

/**
 *
 * @author Cristiano
 */
public class View {
   /**
    * Metodo usado para mostrar o menu que é uma String 
    * em um JOPtionPan
    * @return retorna a String menu com as opções para o usuari escolher
    */    
    public static String  showMenuString(){
     String menu ="";
     
        return menu = "[********Tela de Cadastro********]"+"\n\n"+"[**1**] - Para Cadastrar "+"\n"+
               "[**2**] - Atualizar dados Aluno "+"\n"+"[**3**] - Deletar Cadastro Aluno "+"\n"+
                "[**4**] - Atualizar dados Pessoa "+"\n"+"[**5**] - Deletar Cadastro Pessoa "+"\n"+
                "[**6**] - Listar todos os Cadastros "+"\n"+"[**0**] - Para Sair ";
    
    }
    /**
     * Apenas uma mensagem de boas vindas para o usuário 
     * situando ele que ele esta no contexto de cadastro
     */
    public static void bemVindo(){
        JOptionPane.showMessageDialog(null, "_______BEM VINDO AO CADASTRO DE USUÁRIOS_______", "CADASTRO", 1);
    }
    
    /**
     * Metodo que captura os valores digitados pelo usuario no momento do cadastro de pessoas ou alunos
     * sempre verificando se não existem valores nulos
     * @param msg esse parametro informa o tipo de dado que se quer
     * @return retorna uma String nunca vazia
     */
    public static String getValorString(String msg){
        int teste =0;
         String val = "";
        do{
            val = JOptionPane.showInputDialog(null, msg, "CADASTRO", 1);
            if(!val.isEmpty()){
            teste = 1;
            }else{
                
                JOptionPane.showMessageDialog(null, "Por favor informe o valor solicitado");
            }
            
          }while(teste ==0);
       
        return val;
        
    }
     /**
     *Metodo que captura os valores digitados pelo usuario no momento da atualização de pessoas ou alunos
     * @param msg esse parametro informa o tipo de dado que se quer
     * @return String que pode ser vazia ou com valor depende da necessidade do usuário.
      */  
     public static String getValorStringUp(String msg){
        
          return JOptionPane.showInputDialog(null, msg, "ATUALIZAÇÃO", 1);
     
    } 
     /**
      * Metodo usado para situar o usuário do contexto
      * @param message mensagem que  o usuario precisa receber
      */
     public static void message(String message){
       
          JOptionPane.showMessageDialog(null, message);
     }
}
//}