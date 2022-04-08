/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maisprati.controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import maisprati.model.Pessoa;
import maisprati.util.Util;
import maisprati.view.View;

/**
 *
 * @author Cristiano
 */
public  class PessoaDAO implements InterfaceDAO{
   private List<Pessoa> listaP  =null;
    private Date dtNasc = null;
    public PessoaDAO() {
        
         if(listaP == null){
            
            listaP = new ArrayList<Pessoa>();
        }
    }
    /**
     * Método para adicionar um objeto Pessoa na lista 
     * @param pessoa
     * @return true se conseguiu inserir na lista caso contrario return false
     */
    public boolean add(Object obj) {
        if( listaP.add((Pessoa) obj)){
            return true;
        }else{
            return false;
        }
    }

    /**
      * Método para listar todos os registros cadastrados
      * @return ArrayList<Pessoas>
      */
   public  List<Pessoa> listaTodos() {
         return this.listaP;
    }
    
   /**
     * Método que realiza uma pesquisa em um arrayList recebe uma String e retorna um obj ou null
     * @param String  nome
     * @return obj pessoa
     */
    public Pessoa buscaPorNome(String str) {
        Pessoa pessoa = null;
        
        for(Pessoa p: listaP){
            
            if(p.getNome().equalsIgnoreCase(str)){
               
                pessoa = p;
                break;
            }
        }
        return pessoa;
    }

     /**
     * Metodo usado para atualização de dados, recebe o nome , realiza uma pesquisa
     * Se encontrado salva a posição(index) array e uma variável obj auxiliar
     * após exclui esse obj e realiza as alterações necessarias;
     * depois insere esse obj ja mesma posiçao
     * @param String nome 
     */
    public void atualiza(String str) {
       Pessoa pessoa = null;
        int index = 0;
        for(Pessoa p: listaP){
            
            if(p.getNome().equalsIgnoreCase(str)){
                
                pessoa = p;
                index = this.listaP.indexOf(p);
                break;
            }
        }
            
            delete(index);
          
             JOptionPane.showMessageDialog(null, "PARA ATUALIZAR INSIRA O NOVO VALOR OU APENAS TECLE ENTER");
            
            this.listaP.add(index, getNovosVal(pessoa));
    }
     /**
     * Método para remover elementos do array recebe a posiçao no array
     * @param int index 
     * @return boolean true se conseguiu deletar ou caso contrario falso;
     */
    public boolean delete(int index) {
         if(this.listaP.remove(listaP.get(index)))  {
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
        for(Pessoa p: this.listaP){
           
           if(p.getNome().equalsIgnoreCase(str)){
             
               index = this.listaP.indexOf(p);
               break;
           }
       }
        return index;
    }
    
     
     /**
    * Método usado atualizar atualizar dados, recebe um obj salva uma copia (a)
    * se alguma dado não for atualizado o valor da copia é usado;
    * @param pessoa
    * @return obj aluno atualizado
    */
      protected Pessoa getNovosVal(Pessoa pessoa){
    /**
     * No menu existe uma explicação que caso o usuáio não
     * queira atualizar algum dado é só teclar enter
     */
        Pessoa p = pessoa;
        Scanner input = new Scanner(System.in);
        
        String nome = View.getValorStringUp("Informe o novo valor para o nome");
        
        if(!nome.isEmpty()){
            pessoa.setNome(nome);
        }else{
            pessoa.setNome(p.getNome());
        }
        
        String fone = View.getValorStringUp("Informe o novo valor para o telefone");
        
        if(!fone.isEmpty()){
            
            pessoa.setFone(fone);
        }else{
            
            pessoa.setFone(p.getFone());
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
            }//fim while
          if(dtNasc != null){
            
           pessoa.setNascimento(dtNasc);
           
        } else{
            
            pessoa.setNascimento(p.getNascimento());
        }     
        Date dtAtualicao = new Date();
        pessoa.setAlteracaoCad(dtAtualicao);
        
        return pessoa;
    }

    /**
      * Método para listar todos os alunos cadastrados
      * @return ArrayList<Pessoa>
      */
    public List<Pessoa> getTodos() {
        return this.listaP;
    }

}
  

   
