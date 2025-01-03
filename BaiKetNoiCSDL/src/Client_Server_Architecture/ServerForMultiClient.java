package Client_Server_Architecture;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
 
public class ServerForMultiClient {
 
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        try {
            //Create a server socket
            serverSocket = new ServerSocket(8000);
            while(true) {
                //Listen for a connection request
                Socket socket = serverSocket.accept();
                //create a thread to serve client
                new Thread(new ClientHandler(socket)).start();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                serverSocket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
 
    private static class ClientHandler implements Runnable{
        private Socket socket = null;
        private DataInputStream inputStream = null;
        private DataOutputStream outputStream = null;
        public ClientHandler(Socket socket) { this.socket = socket; }
        @Override
        public void run() {
            try {
                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());
 
                InetAddress inet = socket.getInetAddress();
 
                System.out.println("--------------------------------------------");
                System.out.println("Thread name: " + Thread.currentThread().getName());
                System.out.println("Host name: " + inet.getHostName());
                System.out.println("IP address: " + inet.getHostAddress());
                System.out.println("Local Port: " + socket.getLocalPort());
                System.out.println("Remote Socket Address: " + socket.getRemoteSocketAddress());
 
                while (true) {
                    double radius = inputStream.readDouble();
                    double area = Math.PI * radius * radius;
                    outputStream.writeDouble(area);
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                    inputStream.close();
                    outputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
 
 
//                InetAddress inet = socket.getInetAddress();
//
//                System.out.println("--------------------------------------------");
//                System.out.println("Thread name: " + Thread.currentThread().getName());
//                System.out.println("Host name: " + inet.getHostName());
//                System.out.println("IP address: " + inet.getHostAddress());
//                System.out.println("Local Port: " + socket.getLocalPort());
//                System.out.println("Remote Socket Address: " + socket.getRemoteSocketAddress());
