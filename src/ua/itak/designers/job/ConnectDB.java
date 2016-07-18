/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itak.designers.job;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**

 @author Nezhdanoff
 */
public class ConnectDB {

    private final String IDRIVERSTRING = "jdbc:mysql://";
    private String iHost;
    private String iUser;
    private String iPassword;
    private String iDBName;
    private String iURL;
    private Properties iProperties;
    public Connection iConnection = null;

//    private  boolean iConnected = false;
    public ConnectDB(String Host, String User, String Password, String DBName) {
        LoadDriver();
        this.iHost = Host;
        this.iUser = User;
        this.iPassword = Password;
        this.iDBName = DBName;
        this.iURL = IDRIVERSTRING + iHost + "/" + iDBName;
        //   int reply = JOptionPane.showConfirmDialog(null, "URL :" + iURL, "Title", JOptionPane.YES_NO_OPTION);
    }

    public static void LoadDriver() {

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Не найден путь к классу " + ex.getMessage());
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "Не создан Instance of " + ex.getMessage());
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка доступа к " + ex.getMessage());
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void init() {
        if (iConnection == null) {

            try {
                iConnection = DriverManager.getConnection(
                        iURL, iUser, iPassword
                );
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "База Данных не доступна \n"
                                              + ex.getMessage() + "\n"
                                              + "SQLState: " + ex.getSQLState() + "\n"
                                              + "VendorError: " + ex.getErrorCode()
                );
            }
        }
    }

    public ResultSet query(String Query) {
        ResultSet result = null;
        try {
            Statement stmt = iConnection.createStatement();
            result = stmt.executeQuery(Query);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ошибка выполнения SQL-запроса\n" + Query);
        }
        return result;
    }

    public void updateQuery(String Query) {
        try {
            Statement stmt = iConnection.createStatement();
            stmt.executeUpdate(Query);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ошибка выполнения SQL-запроса\n" + Query);
        }
    }

    public void updateTransactionOneToMany(String qry1, String qry2, String WldCRD) {

        int ID = 0;

        try {
            this.iConnection.setAutoCommit(false);
            Statement ss = this.iConnection.createStatement();
            ss.executeUpdate(qry1);
            ResultSet result = ss.executeQuery("SELECT LAST_INSERT_ID()");
            if (result.next()) {
                ID = result.getInt(1);
            }
            String str = qry2.replace(WldCRD, Integer.toString(ID));
//            JOptionPane.showMessageDialog(null, "Внесена запись с ID=" + ID);
//            query1 = query2.replace("-###-", Integer.toString(ID));
//            System.out.println(qry1);
            ss.executeUpdate(str);
            this.iConnection.commit();
//            JOptionPane.showMessageDialog(null, "Внесена запись с SQL \n"
//                    + qry1.replace("),", "), \n"));
        } catch (SQLException ex) {
            try {
                JOptionPane.showMessageDialog(null, "Ошибка. ОТКАТ ТРАНЗАКЦИИ!");
                this.iConnection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.iConnection.setAutoCommit(true);
                this.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void close() {
        if (iConnection != null) {
            try {
                iConnection.close();
            } catch (SQLException ex) {
                       }
        }
    }
}
