package lk.src.ijse;

import java.io.*;
import java.net.Socket;

public class Clientapp {
    public static void main(String[] args) {
        final int PORT = 8000;
        try {
            Socket   socket = new Socket("localhost", PORT);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            //InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String massage = "", reply = "";

            while (!massage.equals("finish")) {

                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                massage = dataInputStream.readUTF();
                System.out.println("Server says, :" +massage);
                dataOutputStream.flush();
            }
            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();

            //PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
           // printWriter.println("Hello server,kohomada oyta");
           // printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


