/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itak.designers.job;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Nezhdanoff
 */
public class JobsForDesigners {
// Адрес (DNS-Name) : PORT MySQL сервера
//        public static final String SERVER = "base:3306";
//        public static final String SERVER = "ED-HOME-X64-PC:3306";
        public static final String SERVER = "192.168.0.117:3306";
//        public static final String SERVER = "localhost:3306";
// имя пользователя MySQL сервера
        public static final String USER = "itak_user";
//        public static final String USER = "Ed";
// пароль пользователя MySQL сервера
        public static final String PASSWORD = "";
//        public static final String PASSWORD = "123";
// имя Базы Данных MySQL сервера
        public static final String BASE = "itak";
        public static  UserDataObject User = null;
        public static  jFrame_Login LoginWindow = new jFrame_Login();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
           try {
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
          } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
          // handle exception
          }

        LoginWindow.setVisible(true);

    }

}
