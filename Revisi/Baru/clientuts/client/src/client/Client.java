/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
    import java.io.IOException;
    import java.net.Socket;
    import java.io.InputStream;
    import java.io.OutputStream;
    import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class Client {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
           try {
            Scanner sc= new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            byte[] buf;
            Socket socket = new Socket("10.151.43.147", 6666);
            
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            String compare = "\\n";
            //int len;
            while(true) {
               
                buf = new byte[1];
                is.read(buf);
                sb.append(new String(buf));  
                if(sb.length()>3)
                {
                //System.out.println("hasil baca: " + sb.substring(sb.length()-2) + compare);
                if(sb.substring(sb.length()-2).equalsIgnoreCase(compare)) break;
                }
            }
            System.out.println(sb.toString());
            String kak;
            kak = sc.nextLine();
            kak = kak + "\r\n";
            buf=new byte[25];
            buf=kak.getBytes();
            os.write(buf);
            os.flush();
            buf=new byte[30];
            is.read(buf);
            String haha= new String(buf);
            //sb = new StringBuilder();
            while(true) {
                buf = new byte[1];
                is.read(buf);
                //System.out.println("command terbaca");
                String m= new String(buf);
                haha = haha+m;
                //System.out.println("hasil baca:" + m);
                if(haha.length()>6)
                {
                    break;
                }
            } 
//            
            os.close();
            is.close();
            socket.close();
        } 
           catch(IOException ex){
           Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}
    }
    }
    

