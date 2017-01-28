package controller.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CLIclient {

	private void readInputsAndSend(BufferedReader in, PrintWriter out, String exit) { 
		try {
			String line;
			while(!(line = in.readLine()).equals(exit)) {
				out.println(line);
				out.flush();
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
					
	}
		
	private Thread syncReadInputsAndSend(BufferedReader in, PrintWriter out, String exit) {
		Thread t = new Thread(new Runnable(){
			public void run() { 
				readInputsAndSend(in, out, exit); 
			}
		});
		
		t.start();
		return t;
	}

	public void start(String ip, int port){
        try{
            Socket theServer=new Socket(ip, port);
            System.out.println("connected to server");

            BufferedReader userInput=new BufferedReader(new InputStreamReader(System.in));
            BufferedReader serverInput=new BufferedReader(new InputStreamReader(theServer.getInputStream()));

            PrintWriter outScreen=new PrintWriter(System.out);
            PrintWriter outServer=new PrintWriter(theServer.getOutputStream());

            Thread t1= syncReadInputsAndSend(userInput,outServer,"exit"); // Thread to client
            Thread t2= syncReadInputsAndSend(serverInput,outScreen,"bye"); // Thread to the server

            t1.join(); t2.join(); 

            userInput.close();
            serverInput.close();
            theServer.close();
            outScreen.close();
            theServer.close();

        } catch(IOException | InterruptedException e) {
        	e.getStackTrace();
        }
	
	}
	
}
