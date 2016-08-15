/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itak.designers.job;

/**

 @author Nezhdanoff
 */
public class Seconds_TO_HMS {

    private Seconds_TO_HMS() {
    }

    public  static String toString(long _seconds){

        int hours = (int)_seconds / 3600;
        int minutes = (int)(_seconds - hours * 3600)/60;
        int seconds = (int)(_seconds - ((int)_seconds / 60) * 60);


        return "" + (hours <= 9 ? ("00" + hours) : (hours <= 99 ? "0" + hours : hours))
                + ":"
                + (minutes <= 9 ? "0" + minutes : minutes)
                + ":"
                + (seconds <= 9 ? "0" + seconds : seconds);
    }

}
