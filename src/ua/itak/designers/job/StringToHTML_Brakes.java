/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itak.designers.job;

/**

 @author Nezhdanoff
 */
public class StringToHTML_Brakes {

    private StringToHTML_Brakes() {
    }


    public static String toString(String str) {
        return "<html>"+ str.replaceAll(";", ";<br>") + "</html>";
    }

    public static String toString(String str, String shablon) {
        return "<html>"+ str.replaceAll(shablon, ";<br>") + "</html>";
    }
}
