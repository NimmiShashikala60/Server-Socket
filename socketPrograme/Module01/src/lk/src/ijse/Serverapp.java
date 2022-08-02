package lk.src.ijse;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverapp {
    public static void main(String args[]) {
        final int PORT = 8000;
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);


            System.out.println("Server is ranning in port : " + PORT);

            Socket localSocket = serverSocket.accept();
            // System.out.println("Port"+localSocket.getPort());
            // System.out.println("Ip"+localSocket.getInetAddress());
            System.out.println("client accept..");

            // InputStreamReader inputStreamReader = new InputStreamReader(localSocket.getInputStream());
            // BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // String clientMag = bufferedReader.readLine();

            //System.out.println("client says: "+clientMag);
            DataOutputStream dataOutputStream = new DataOutputStream(localSocket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(localSocket.getInputStream());

            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String massage = "", reply = "";

            while (!massage.equals("finish")) {
                massage = dataInputStream.readUTF();
                System.out.println(massage);
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();

                dataInputStream.close();
                dataOutputStream.close();
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
