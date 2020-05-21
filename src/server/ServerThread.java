package server;

import server.ChatThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread {


    @Override
    public void run() {
        try {
            ServerSocket serverSocket=new ServerSocket(9999);
            while (true){
                Socket socket=serverSocket.accept();

                ChatThread chatThread=new ChatThread(socket);
                chatThread.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
