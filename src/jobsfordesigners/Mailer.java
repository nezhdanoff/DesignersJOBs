package jobsfordesigners;

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
   static PrintStream ps = null;          // ������� ���������
   static DataInputStream dis = null;     // ��������� ���������

   public static void send(String str) throws IOException
     {
        ps.println(str);      // ������� ������ �� SMTP
        ps.flush();           // ������� ������
        System.out.println("Java sent: " + str);
     }

   public static void receive() throws IOException
     {
        String readstr = dis.readLine();  // ��������� ������ �� SMTP
        System.out.println("SMTP respons: " + readstr);
     }
    public static void sendMailTo(String rcpt, String subj, String body) {

        String HELO = "HELO ";
        String MAIL_FROM = "MAIL FROM: <reprocentr@itak.ua> ";
        String RCPT_TO = "RCPT TO: <" + rcpt + "> ";
        String SUBJECT = "SUBJECT: " + subj;
        String DATA = "DATA ";    // ������ ���������*/


        // �������: "\r\n.\r\n" ��������� �� ����� ���������
        String BODY = body + "\r\n.\r\n";

        Socket smtp = null;     // ����� SMTP

        try {  // �������: 25 - ��� ����������� ����� ����� SMTP
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

        try {  // ������ SMTP helo
            String loc = InetAddress.getLocalHost().getHostName();
            send(HELO + loc);
            receive();          // ��������� ������ SMTP
            send(MAIL_FROM);    // ������� �� SMTP
            receive();          // ��������� ������ SMTP
            send(RCPT_TO);      // ������� �������� SMTP
            receive();          // ��������� ������ SMTP
            send(DATA);         // ���������� ������� �� SMTP
            receive();          // ��������� ������ SMTP
            send(SUBJECT);      // ������� ���� �� SMTP
            receive();          // ��������� ������ SMTP
            send(BODY);         // ������� ���� ���������
            receive();          // ��������� ������ SMTP
            smtp.close();       //
          }
        catch (IOException e)
          {
            System.out.println("Error sending: " + e);
          }
        System.out.println("Mail sent!");
   }
}
