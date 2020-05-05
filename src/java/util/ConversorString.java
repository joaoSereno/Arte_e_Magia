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
public class ConversorString {

    public String ConvereterString(String string) throws UnsupportedEncodingException{
        
        byte array[] = string.getBytes("ISO-8859-1");
        String novaString = new String(array, "UTF-8");
        
        return novaString;
    }
}
