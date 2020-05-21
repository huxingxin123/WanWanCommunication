package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("127.0.0.1",9999);
            System.out.println("链接成功，欢迎来到湾湾阴间论坛");
            new Thread(new InputCLientThread(socket)).start();

           new Thread(new OutputClientThread(socket)).start();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
