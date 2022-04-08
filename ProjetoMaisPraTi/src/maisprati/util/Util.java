/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maisprati.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import maisprati.controler.AlunoDAO;

/**
 *
 * @author Alfamidia
 */
public class Util {
    
       /**
        * Método ultilizado para realizar um parse de String para Date
        * @param String sdate
        * @return Date
        */
    public static Date stringToDate(String sdate){
       Date data = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
         if(verificaUnidades(sdate)){
         
             try {
                 data = formato.parse(sdate);

             } catch (ParseException ex) {

                 System.err.println("ERRO AO CONVERTER DATA " + ex.getMessage());
                 return null;
             } catch (DateTimeParseException ex) {
                 System.err.println("ERRO AO CONVERTER DATA " + ex.getMessage());
                 return null;
             }
            }else{
         
             return null;
           }
       
        return data;
       
    }
        /**
         * Método utilzado para realizar um parse da Data para  String
         * @param Date date
         * @return String 
         */
     public static String dateTostring(Date date){
         
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String stringData = dateFormat.format(date);
        
        return stringData;
    }
     /**
      * Metodo usado para verificar se o usuário digitou valores dentro de parametros validos 
      * para  as datas 
      * @param str String data
      * @return true se esta tudo certo
      */
   private static boolean verificaUnidades(String str){
        boolean vai = false;
        int anoAtual= Calendar.getInstance().get(Calendar.YEAR);
        String [] data = str.split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);
        
        if((dia <= 31) && (mes <= 12) && (ano <= anoAtual)){
            vai = true;
        }else{
           vai = false;
        }
     return vai;
    
    }
}
