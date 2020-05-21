package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class InputCLientThread extends Thread {
    Socket socket;

    public InputCLientThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                String str = br.readLine();
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    }



