import java.io.*;
import java.net.*;
import java.util.*;

public class VerySimpleChatServer {

    ArrayList<PrintWriter> clientOutputStreams;


    public class ClientHandler implements Runnable {

         PrintWriter writer;
         BufferedReader reader;
       
         Socket sock;
   

         public ClientHandler(Socket clientSocket, PrintWriter writer) {
           try {
             this.writer= writer;
             sock = clientSocket;
             InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
             reader = new BufferedReader(isReader);
              
           } catch(Exception ex) {ex.printStackTrace();}
          } // close constructor

        public void run() {
           String message;
             
           try {

             while ((message = reader.readLine()) != null) {
                        
                System.out.println("read " + message);
                tellEveryone(message, writer);
    
              } // close while
           } catch(Exception ex) {ex.printStackTrace();}
       } // close run
   } // close inner class
      



     public static void main (String[] args) {
         new VerySimpleChatServer().go();
    }

     public void go() {
      clientOutputStreams = new ArrayList<PrintWriter>();

       try {
       ServerSocket serverSock = new ServerSocket(5000);

       while(true) {
          Socket clientSocket = serverSock.accept();
          PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());         
          clientOutputStreams.add(writer);

       Thread t = new Thread(new ClientHandler(clientSocket, writer));
       t.start();


       System.out.println("got a connection");
     }
       // now if I get here I have a connection
               
      }catch(Exception ex) {
         ex.printStackTrace();
      }
   }

   public void tellEveryone(String message, PrintWriter writerp) {
      Iterator it = clientOutputStreams.iterator();
      while(it.hasNext()) {
        try {
           PrintWriter writer = (PrintWriter) it.next();
	   if(!writer.equals(writerp)){
           	writer.println(message);
           	writer.flush();
	   }
         } catch(Exception ex) {
              ex.printStackTrace();
         }
      
       } // end while
       
   } // close tellEveryone


}
       