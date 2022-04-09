/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maisprati.controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import maisprati.model.Aluno;
import maisprati.model.Pessoa;
import maisprati.util.Util;
import maisprati.view.View;

/**
 *
 * @author Alfamidia
 */
public class AlunoDAO implements InterfaceDAO{

    private Date dtNasc = null;
    private  List<Aluno> listaA = null;
    
    public AlunoDAO() {
        
         if(listaA == null){
            
            listaA = new ArrayList<Aluno>();
        }
    }
     
    /**
     * Método para adicionar um objeto Aluno na lista 
     * @param aluno
     * @return true se conseguiu inserir na lista caso contrario return false
     */
  
    public boolean add(Object obj) {
        
       if(listaA.add((Aluno) obj)){
           return true;
       }else{
        return false;
       }
    }

    /**
     * Método que realiza uma pesquisa em um arrayList recebe uma String e retorna um obj ou null
     * @param String  nome
     * @return obj aluno
     */
 
    public Aluno buscaPorNome(String str) {
      Aluno aluno = null;
        
       for(Aluno a: this.listaA){
           
           if(a.getNome().equalsIgnoreCase(str)){
               aluno = a;
               break;
           }
       }
        
        return aluno;
    }
    
     /**
     * Metodo usado para atualização de dados, recebe o nome , realiza uma pesquisa
     * Se encontrado salva a posição(index) array e uma variável obj auxiliar
     * após exclui esse obj e realiza as alterações necessarias;
     * depois insere esse obj ja mesma posiçao
     * @param String nome 
     */

    public void atualiza(String str) {
        Aluno aluno = null ;
        int index=0;
        
        for(Aluno a: this.listaA){
           
           if(a.getNome().equalsIgnoreCase(str)){
               aluno = a;
               index = this.listaA.indexOf(a);
               break;
           }
       }
//          
        delete(index);
    
        JOptionPane.showMessageDialog(null, "PARA ATUALIZAR INSIRA O NOVO VALOR OU APENAS TECLE ENTER");
         
//         salva o obj aluno na posição 
        this.listaA.add(index, getNovosVal(aluno));
    }
    /**
     * Método para remover elementos do array recebe a posiçao no array
     * @param int index 
     * @return boolean true se conseguiu deletar ou caso contrario falso;
     */
    
    public boolean delete(int index) {
        
     if(listaA.remove(listaA.get(index))){
       return true;
     }else{
         
         return false;
     }
  }

    /**
     * Metodo que retorna o index do objeto dentro do ArrayList
     * @param str String nome
     * @return int index 
     */
    
    public int getIndex(String str) {
       int index = 0;
        for(Aluno a: this.listaA){
           
           if(a.getNome().equalsIgnoreCase(str)){
             
               index = this.listaA.indexOf(a);
               break;
           }
       }
        return index;
    }
    
    /**
      * Método para listar todos os alunos cadastrados
      * @return ArrayList<Alunos>
      */
   
    public List<Aluno> getTodos() {
       return this.listaA;
    }
    
     /**
    * Método usado atualizar atualizar dados, recebe um obj salva uma copia (a)
    * se alguma dado não for atualizado o valor da copia é usado;
    * @param aluno
    * @return obj aluno atualizado
    */
    protected Aluno getNovosVal(Aluno aluno){
    /**
     * No menu existe uma explicação que caso o usuáio não
     * queira atualizar algum dado é só teclar enter
     */
        Aluno a = aluno;
       
        
       String nome = View.getValorStringUp("Informe o novo valor para o nome");
        
        if(!nome.isEmpty()){
            aluno.setNome(nome);
        }else{
            aluno.setNome(a.getNome());
        }
        
        String fone = View.getValorStringUp("Informe o novo valor para o telefone");
        
        if(!fone.isEmpty()){
            
            aluno.setFone(fone);
        }else{
            
            aluno.setFone(a.getFone());
        }
      
        String sdtNasc = "";
        int testeData  =0;
         while(testeData == 0){
                
               sdtNasc= View.getValorStringUp("Informe data Nascimento para atualizar : formato (10/09/1979) ");
               
               if(sdtNasc.isEmpty()){
                   
                   testeData = 1;
                   break;
               }
               dtNasc = Util.stringToDate(sdtNasc);
              
                 if(dtNasc != null){
                     testeData = 1;
                  }else{

                    JOptionPane.showMessageDialog(null, "Formato errado tente esse (10/09/1979) ");
                 }
            }//fim 
         
        if(dtNasc != null){
            
           aluno.setNascimento(dtNasc);
           
        } else{
            
            aluno.setNascimento(a.getNascimento());
        }        
       
        Date dtAtualicao = new Date();
        aluno.setAlteracaoCad(dtAtualicao);
        aluno.setAlteraCad(true);
        
       
        double notaF = 0;  
        String snotaF = View.getValorStringUp("Informe a nota final no aluno");
           
        if(!snotaF.isEmpty()){
            notaF = Double.parseDouble(snotaF);
            aluno.setNotaF(notaF);
        }else{
            
           aluno.setNotaF(a.getNotaF());
        }
       
        return aluno;
    }
    
}
