/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomaisprativ_2;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import maisprati.controler.AlunoDAO;
import maisprati.controler.InterfaceDAO;
import maisprati.controler.PessoaDAO;
import maisprati.model.Aluno;
import maisprati.model.Pessoa;
import maisprati.util.Util;
import maisprati.view.View;

/**
 *
 * @author Cristiano
 */
public class Main {
    
    private static InterfaceDAO   daoAluno;
    private static InterfaceDAO   daoP;
    
    public static void main(String[] args){
    
        daoAluno =  new AlunoDAO();  
        daoP     =  new PessoaDAO();
        List<Pessoa> listaP  = null;
        List<Aluno> listaA   = null;
     
    int resp = 0;
    String respS = "";   
       do {
           
            respS = JOptionPane.showInputDialog(null, View.showMenuString());
                
            if(!respS.isEmpty()){
                
                resp = Integer.parseInt(respS);
                
                switch (resp) {
                        //Cadastro de pessoas ou alunos
                        case 1:
                            View.bemVindo();
                            getDados();
                            break;
                         //Atualiza√ß√£o do cadastro de Alunos
                        case 2:
                             listaA = (List<Aluno>) daoAluno.getTodos();

                             if(!listaA.isEmpty()){
                                 String listaAlunos = "";
                                 String id = "";
                                 for(int i=0; i<listaA.size();i++){
                                     
                                     listaAlunos +="ID--> "+listaA.indexOf(listaA.get(i))+"\n"+ listaA.get(i)+"\n-----------------------\n";
                                 }
                                 id = JOptionPane.showInputDialog(null, listaAlunos, "ESCOLHA UM ID PARA ATUALIZAR", 1);
                                 if(!id.isEmpty()){
                                     
                                      int index = Integer.parseInt(id);
                                      daoAluno.atualiza(listaA.get(index).getNome());
                                 }else{
                                 
                                     JOptionPane.showMessageDialog(null, " ID N√O INFORMADO !");
                                 }
                                 

                             }else{

                               JOptionPane.showMessageDialog(null, "SEM DADOS PARA ATUALIZAR ");
                             }

                            break;

                        case 3:
                            //Exclus√£o de cadastro de alunos
                            listaA = (List<Aluno>) daoAluno.getTodos();
                            if (!listaA.isEmpty()) {
                                String listaAlunos = "";
                                String id = "";

                                for (int i = 0; i < listaA.size(); i++) {

                                    listaAlunos += "ID>>> " + listaA.indexOf(listaA.get(i)) + "\n" + listaA.get(i) + "\n----------------------\n";
                                }
                                id = JOptionPane.showInputDialog(null, listaAlunos, "ESCOLHA UM ID PARA EXCLUIR", 1);
                                if (!id.isEmpty()) {
                                    
                                    int index = Integer.parseInt(id);

                                    if (daoAluno.delete(index)) {
                                        JOptionPane.showMessageDialog(null, "ELMENTO REMOVIDO COM SUCESSO");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "N√O FOI POSSÕVEL REALIZAR OPERA«√O");
                                    }
                                    
                                } else {

                                    JOptionPane.showMessageDialog(null, "NENHUM ELEMENTO SELECIONADO!");
                                }

                            } else {

                                JOptionPane.showMessageDialog(null, "LISTA VAZIA");
                            }

                            break;
                        case 4:
                            //AtualizaÁ„o de cadastro de Pessoas
                            listaP = (List<Pessoa>) daoP.getTodos();

                             if(!listaP.isEmpty()){
                                 String listaPessoa = "";
                                 String idp = "";
                                 for(int i=0; i<listaP.size();i++){
                                     
                                     listaPessoa +="ID>>> "+listaP.indexOf(listaP.get(i))+"\n"+ listaP.get(i)+"\n------------------------\n";
                                 }
                                 idp = JOptionPane.showInputDialog(null, listaPessoa, "ESCOLHA UM ID PARA ATUALIZAR", 1);
                                 if(!idp.isEmpty()){
                                     
                                      int index = Integer.parseInt(idp);
                                      daoP.atualiza(listaP.get(index).getNome());
                                 }else{
                                 
                                     JOptionPane.showMessageDialog(null, "ID N√O INFORMADO!");
                                 }
                                 

                             }else{

                               JOptionPane.showMessageDialog(null, "SEM DADOS PARA ATUALIZAR");
                             }

                            break;
                        case 5:
                            //Exclus√£o de cadastro de pessoas
                            listaP = (List<Pessoa>) daoP.getTodos();
                            
                            if(!listaP.isEmpty()){
                            
                                String listaPessoa ="";
                                String idp="";
                                
                                for(int i=0; i <listaP.size(); i++){
                                    
                                    listaPessoa +="ID>>> "+listaP.indexOf(listaP.get(i))+"\n"+listaP.get(i)+"\n-------------------------\n";
                                }
                                
                                idp = JOptionPane.showInputDialog(null, listaPessoa, "ESCOLHA UM ID PARA EXCLUIR", 1);
                                if(!idp.isEmpty()){
                                    
                                    int index = Integer.parseInt(idp);
                                    
                                       if (daoP.delete(index)) {
                                        JOptionPane.showMessageDialog(null, "ELEMENTO REMOVIDO COM SUCESSO");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "N√O FOI POSSÕVEL REALIZAR A OPERA«√O");
                                    }
                                
                                }else{
                                    JOptionPane.showMessageDialog(null, "NENHUM ELEMENTO SELECIONADO");
                                }
                                
                            }else{
                                
                                JOptionPane.showMessageDialog(null, "LISTA VAZIA");
                            }
                            break;
                        case 6:
                            //Lista todos os registros existentes
                            
                            listaA = (List<Aluno>) daoAluno.getTodos();
                            listaP = (List<Pessoa>) daoP.getTodos();
                            
                            String listaPessoas = "";
                            String listaAlunos = "";
                            
                            for(Aluno aluno: listaA)
                            	{
                            		if(aluno.isAlteraCad())
                            			{
                            			 listaAlunos += aluno.cadAlterado() +"\n--------------------------\n";
                            			}else 
                            				{
                            				 listaAlunos += aluno.toString() +"\n--------------------------\n";
                            				}
                            	
                            	}
                           
                            for(Pessoa pessoa: listaP)
                            	{
                            		if(pessoa.isAlteraCad())
                            			{
                            				listaPessoas += pessoa.cadAlterado() +"\n--------------------------\n";
                            			}else 
                            				{
                            				listaPessoas += pessoa.toString() +"\n--------------------------\n";	
                            				}
                            	}
                           
                            
                            if(listaAlunos.isEmpty()){
                                
                                listaAlunos = "SEM DADOS PARA EXIBI«√O";
                            }
                            if(listaPessoas.isEmpty()){
                                
                                listaPessoas ="SEM DADOS PARA EXIBI«√O";
                            }
                            JOptionPane.showMessageDialog(null,"LISTA DE ALUNOS \n"+ listaAlunos +"\n\n"+"LISTA DE PESSOAS \n"+listaPessoas);
                            break;
                        default:
                            System.out.println("DEFAULT");

                    }
            }else{
                JOptionPane.showMessageDialog(null, "ESCOLHA AO MENOS UMA OP«√O!");
                resp= 10;
            }
                    

        }while(resp != 0);

    }
    /**
     * Metodo usado para cadastrar objtos dentro do programa
     * cadastra Alunos e Pessoas
     */
    public static void getDados(){
        Date dtNasc = null;
        Date  dtCad = null;
        Date dtAlteraCad = null;
        int testeData = 0;
      
       String  nome = View.getValorString("IMFORME O NOME:");
    
       String fone = View.getValorString("INFORME O TELEFONE:");
       
            while(testeData == 0){
                
              String sdtNasc= View.getValorString("INFORME A DATA DE NASCIMENTO EX:(10/09/1979) ");
             
               dtNasc = Util.stringToDate(sdtNasc);
              
                 if(dtNasc != null){
                     testeData = 1;
                  }else{

                    JOptionPane.showMessageDialog(null, "FORMATO ERRADO TENTE NOVAMENTE(10/09/1979) ");
                 }
            }
        
        
            dtCad = new Date();
      
       String testeS = View.getValorString("NOTA FINAL (1)SIM (2)N√O : ");
        
         if(!testeS.isEmpty()){

            int teste = Integer.parseInt(testeS);

                if(teste == 1){

                    String notaS=    View.getValorString("INFORME A NOTA FINAL DO ALUNO");

                          if(!notaS.isEmpty()){
                              double notaF = Double.parseDouble(notaS);
                              Aluno a = new Aluno( nome, fone, dtNasc, dtCad, dtCad,notaF);
                              
                             if(daoAluno.add(a)) {
                               
                                View.message("ALUNO CADASTRADO COM SUCESSO!");
                             }else{
                                View.message("N√O FOI POSSÕVEL REALIZAR O CADASTRO!");
                             }
                          }else{
                             //Se a nota final do aluno for 0
                             Aluno a = new Aluno( nome, fone, dtNasc, dtCad, dtCad,0);
                              if(daoAluno.add(a)) {
                               
                                View.message("ALUNO CADASTRADO COM SUCESSO!");
                             }else{
                                View.message("N√O FOI POSSÕVEL REALIZAR O CADASTRO!");
                             }
                          }  


                }else{
                    Pessoa p =new Pessoa(nome, fone, dtNasc, dtCad, dtCad);
                    if(daoP.add(p)) {
                          View.message("PESSOA CADASTRADO COM SUCESSO !");
                                                 
                         }else{
                          View.message("N√O FOI POSSÕVEL REALIZAR O CADASTRO!");
                      }
            }//fim teste se cadastra aluno ou pessoa
         }
         
    }//fim getDados()
        
  }
    
//}
