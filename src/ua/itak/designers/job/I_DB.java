/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itak.designers.job;

/**

 @author Nezhdanoff
 */

public interface I_DB {
//***** Адрес (DNS-Name) : PORT MySQL сервера
//        public static final String SERVER = "base:3306";
//        public static final String SERVER = "ED-HOME-X64-PC:3306";
//        public static final String SERVER = "localhost:3306";
        public static final String SERVER = "192.168.0.117:3306";

//***** имя пользователя MySQL сервера
//        public static final String USER = "Ed";
        public static final String USER = "itak_user";

//***** пароль пользователя MySQL сервера
//        public static final String PASSWORD = "123";
        public static final String PASSWORD = "";

//***** имя Базы Данных MySQL сервера
        public static final String BASE = "itak";
}
