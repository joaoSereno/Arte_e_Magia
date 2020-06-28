/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author João Pedro
 */
public class Conversor {

    public String ConvereterString(String string) throws UnsupportedEncodingException{
        
        byte array[] = string.getBytes("ISO-8859-1");
        String novaString = new String(array, "UTF-8");
        
        return novaString;
    }
    
    public String formatarData(String data){
        
        String dataFormatada = "";
        
        dataFormatada = dataFormatada + data.substring(6,10);
        dataFormatada = dataFormatada + data.substring(3,5);
        dataFormatada = dataFormatada + data.substring(0,2);
          
        return dataFormatada;
    }
    
    public String formatarData2(String data){
        
        String dataFormatada = "";

        dataFormatada = dataFormatada + data.substring(8,10) + "/";
        dataFormatada = dataFormatada + data.substring(5,7) + "/";
        dataFormatada = dataFormatada + data.substring(0,4);
  
        return dataFormatada;
    }
    
}
