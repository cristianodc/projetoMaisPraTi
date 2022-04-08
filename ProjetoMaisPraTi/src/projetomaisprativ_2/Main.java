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
                         //Atualização do cadastro de Alunos
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
                                 
                                     JOptionPane.showMessageDialog(null, "Id não informado!");
                                 }
                                 

                             }else{

                               JOptionPane.showMessageDialog(null, "Sem dados para atualizar");
                             }

                            break;

                        case 3:
                            //Exclusão de cadastro de alunos
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
                                        JOptionPane.showMessageDialog(null, "Elemento removido com sucesso");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Não foi possivel realizar Operação");
                                    }
                                    
                                } else {

                                    JOptionPane.showMessageDialog(null, "Nenhum elemento selecionado!");
                                }

                            } else {

                                JOptionPane.showMessageDialog(null, "Lista vazia");
                            }

                            break;
                        case 4:
                            //Atualização de cadatro de Pessoas
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
                                 
                                     JOptionPane.showMessageDialog(null, "Id não informado!");
                                 }
                                 

                             }else{

                               JOptionPane.showMessageDialog(null, "Sem dados para atualizar");
                             }

                            break;
                        case 5:
                            //Exclusão de cadastro de pessoas
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
                                        JOptionPane.showMessageDialog(null, "Elemento removido com sucesso");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Não foi possivel realizar Operação");
                                    }
                                
                                }else{
                                    JOptionPane.showMessageDialog(null, "Nenhum elemento selecionado");
                                }
                                
                            }else{
                                
                                JOptionPane.showMessageDialog(null, "Lista Vazia");
                            }
                            break;
                        case 6:
                            //Lista todos os registros existentes
                            
                            listaA = (List<Aluno>) daoAluno.getTodos();
                            listaP = (List<Pessoa>) daoP.getTodos();
                            
                            String listaPessoas = "";
                            String listaAlunos = "";
                            
                            for(int i=0; i<listaA.size(); i++){
                                
                                listaAlunos += listaA.get(i)+"\n--------------------------\n";
                            }
                            
                            for(int j=0; j<listaP.size(); j++){
                                
                                listaPessoas += listaP.get(j)+"\n--------------------------\n";
                            }
                            
                            if(listaAlunos.isEmpty()){
                                
                                listaAlunos = "SEM DADOS PARA EXIBIÇÃO";
                            }
                            if(listaPessoas.isEmpty()){
                                
                                listaPessoas ="SEM DADOS PARA EXIBIÇÃO";
                            }
                            JOptionPane.showMessageDialog(null,"LISTA DE ALUNOS \n"+ listaAlunos +"\n\n"+"LISTA DE PESSOAS \n"+listaPessoas);
                            break;
                        default:
                            System.out.println("DEFAULT");

                    }
            }else{
                JOptionPane.showMessageDialog(null, "Escolha ao menos uma Opção!");
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
        int testeData = 0;
      
       String  nome = View.getValorString("Informe o nome:");
    
       String fone = View.getValorString("Informe o telefone:");
       
            while(testeData == 0){
                
              String sdtNasc= View.getValorString("Informe data Nascimento (10/09/1979) ");
             
               dtNasc = Util.stringToDate(sdtNasc);
              
                 if(dtNasc != null){
                     testeData = 1;
                  }else{

                    JOptionPane.showMessageDialog(null, "Formato errado tente esse (10/09/1979) ");
                 }
            }
        
        
            dtCad = new Date();
      
       String testeS = View.getValorString("Nota final (1)SIM (2)NÃO : ");
        
         if(!testeS.isEmpty()){

            int teste = Integer.parseInt(testeS);

                if(teste == 1){

                    String notaS=    View.getValorString("Informe a nota final do aluno ");

                          if(!notaS.isEmpty()){
                              double notaF = Double.parseDouble(notaS);
                              Aluno a = new Aluno( nome, fone, dtNasc, dtCad, dtCad,notaF);
                              
                             if(daoAluno.add(a)) {
                               
                                View.message("Aluno cadastrado com sucesso ");
                             }else{
                                View.message("Não foi possível realizar o cadastro");
                             }
                          }else{
                             //Se a nota final do aluno for 0
                             Aluno a = new Aluno( nome, fone, dtNasc, dtCad, dtCad,0);
                              if(daoAluno.add(a)) {
                               
                                View.message("Aluno cadastrado com sucesso ");
                             }else{
                                View.message("Não foi possível realizar o cadastro");
                             }
                          }  


                }else{
                    Pessoa p =new Pessoa(nome, fone, dtNasc, dtCad, dtCad);
                    if(daoP.add(p)) {
                          View.message("Pessoa cadastrado com sucesso ");
                                                 
                         }else{
                          View.message("Não foi possível realizar o cadastro");
                      }
            }//fim teste se cadastra aluno ou pessoa
         }
         
    }//fim getDados()
        
  }
    
//}
