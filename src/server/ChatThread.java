package server;

import java.io.*;
import java.net.Socket;

public class ChatThread extends Thread {

    Socket socket;

    public ChatThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ServerThreadManger manger=ServerThreadManger.getInstance();
            manger.add(socket);

            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                String str=reader.readLine();
               manger.send(socket,str);
            }
        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
