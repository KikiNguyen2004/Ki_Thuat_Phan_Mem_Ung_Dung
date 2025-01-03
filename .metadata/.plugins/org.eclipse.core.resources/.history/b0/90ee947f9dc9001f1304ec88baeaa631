package Client_Server_Architecture;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server {
 
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        DataInputStream inputStream = null;
        DataOutputStream outputStream = null;
        try {
            //Create a server socket
            serverSocket = new ServerSocket(8000);
            socket = serverSocket.accept();
            // Tạo luồng nhập và xuất
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
 
            // Xử lý dữ liệu từ client
            while (true) {
                double radius = inputStream.readDouble(); // Nhận bán kính
                double area = Math.PI * radius * radius; // Tính diện tích
                outputStream.writeDouble(area);          // Gửi kết quả
                System.out.println("Received radius: " + radius + ", Calculated area: " + area);
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
}
