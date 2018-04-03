import java.io.*;
import java.net.*;

public class EchoServer
{
  public static void main(String[] args) throws Exception
  {
      ServerSocket sersock = new ServerSocket(3000);
      System.out.println("Server ready for chatting");
      Socket sock = sersock.accept( );                          
      // reading from keyboard (keyRead object)
      BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
	  // sending to client (pwrite object)
      OutputStream ostream = sock.getOutputStream(); 
      PrintWriter pwrite = new PrintWriter(ostream, true);

      // receiving from server ( receiveRead  object)
      InputStream istream = sock.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

      String receiveMessage, sendMessage;               
      do
      {
      	receiveMessage = receiveRead.readLine();
      	System.out.println("Received: " + receiveMessage); 
      	sendMessage = new String(receiveMessage);
      	pwrite.println(sendMessage); 
      	pwrite.flush(); 
        if((receiveMessage.equalsIgnoreCase("ok"))||(sendMessage.equalsIgnoreCase("ok"))) 
        {
        	System.out.println("Server exiting...");	
		System.exit(0);   
        }   
      } while(true);	
    }                    
}                        

