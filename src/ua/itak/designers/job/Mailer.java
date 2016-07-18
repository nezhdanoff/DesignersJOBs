package ua.itak.designers.job;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.net.*;
/**
 *
 * @author Nezhdanoff
 */
public class Mailer {
   static PrintStream ps = null;          // посылка сообщений
   static DataInputStream dis = null;     // получение сообщений

   public static void send(String str) throws IOException
     {
        ps.println(str);      // посылка строки на SMTP
        ps.flush();           // очистка буфера
        System.out.println("Java sent: " + str);
     }

   public static void receive() throws IOException
     {
        String readstr = dis.readLine();  // получение ответа от SMTP
        System.out.println("SMTP respons: " + readstr);
     }
    public static void sendMailTo(String rcpt, String subj, String body) {

        String HELO = "HELO ";
        String MAIL_FROM = "MAIL FROM: <reprocentr@itak.ua> ";
//        String RCPT_TO = "RCPT TO: <nezhdanoff@itak.ua> ";
        String RCPT_TO = "RCPT TO: <" + rcpt + "> ";
        String SUBJECT = "SUBJECT: " + subj;
//        String MIME_VERSION = "MIME-Version: 1.0 \r\n" ;
        String CONTENT_TYPE = "Content-Type: text/plain; charset=UTF-8; "
                + "Content-Transfer-Encoding: 8bit ;";
        String DATA = "DATA ";    // начало сообщения*/


        // заметка: "\r\n.\r\n" указывает на конец сообщения
        String BODY =  body + "\r\n.\r\n";

        Socket smtp = null;     // сокет SMTP

        try {  // заметка: 25 - это стандартный номер порта SMTP
            smtp = new Socket("192.168.0.1", 25);
            OutputStream os = smtp.getOutputStream();
            ps = new PrintStream(os);
            InputStream is = smtp.getInputStream();
            dis = new DataInputStream(is);
          }
        catch (IOException e)
          {
            System.out.println("Error connection: " + e);
          }

        try {  // скажем SMTP helo
            String loc = InetAddress.getLocalHost().getHostName();
            send(HELO + loc);
            receive();          // получение ответа SMTP
            send(MAIL_FROM);    // посылка на SMTP
            receive();          // получение ответа SMTP
            send(RCPT_TO);      // посылка адресату SMTP
            receive();          // получение ответа SMTP
            send(DATA);         // начинается посылка на SMTP
            receive();          // получение ответа SMTP
            send(SUBJECT);      // посылка темы на SMTP
            receive();          // получение ответа SMTP
//            send(MIME_VERSION);         // посылка MIME_VERSION
            send(CONTENT_TYPE);         // посылка CONTENTTYPE
//            send(CONTENT_ENCODING);     // посылка CONTENT_ENCODING
            send(BODY);         // посылка тела сообщения
            receive();          // получение ответа SMTP
            smtp.close();       //
          }
        catch (IOException e)
          {
            System.out.println("Error sending: " + e);
          }
        System.out.println("Mail sent!");
   }
}
