package Client_Server_Architecture;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client2 {
	public static void main(String args[]){
        Socket socket = null;
        double radius = 1.0;
        DataInputStream inputStream = null;
        DataOutputStream outputStream = null;
        int count = 0;
        try{
            //Create a socket to connect to the server
            socket = new Socket("localhost", 8000);
            //Create data input and output streams
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            while(true) {
                radius = Math.random() * 10;
                //send radius to server
                outputStream.writeDouble(radius);
                //read area from server
                double area = inputStream.readDouble();
                System.out.println((++count) + ": radius = " + radius + " area = " + area);
                Thread.sleep(2000);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                socket.close();
                inputStream.close();
                outputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

