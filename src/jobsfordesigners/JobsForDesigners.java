/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobsfordesigners;


/**
 *
 * @author Nezhdanoff
 */
public class JobsForDesigners {
    // Адрес (DNS-Name) : PORT MySQL сервера
//        public static final String SERVER = "base:3306";
//        public static final String SERVER = "ED-HOME-X64-PC:3306";
//        public static final String SERVER = "pc-117:3306";
        public static final String SERVER = "localhost:3306";
    // имя пользователя MySQL сервера
        public static final String USER = "itak_user";
    // пароль пользователя MySQL сервера
        public static final String PASSWORD = "";
    // имя Базы Данных MySQL сервера
        public static final String BASE = "itak";
        public static  UserDataObject User = null;
        public static  LoginJFrame LoginWindow = new LoginJFrame();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        LoginJFrame LoginWindow = new LoginJFrame();
        LoginWindow.setVisible(true);

    }

}
