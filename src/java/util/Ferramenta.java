/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jean
 */
public class Ferramenta {
    public static String exprAno(String linha, String padrao){
        Pattern p = Pattern.compile(padrao);
        Matcher m = p.matcher(linha);
        String result="";
        if(m.find()){
            result = m.group();
        }
        return result;
    }
}
