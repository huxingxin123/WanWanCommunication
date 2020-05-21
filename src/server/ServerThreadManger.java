package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThreadManger {
    private ServerThreadManger (){}

   private static ServerThreadManger serverThreadManger=new ServerThreadManger();

    public static ServerThreadManger getInstance(){
        return serverThreadManger;
    }

    private List<Socket> mlist=new ArrayList<>();

    public void add(Socket s){
        mlist.add(s);
    }

    public void send(Socket s,String msg) throws IOException {
        for (Socket socket: mlist){
            if (!socket.equals(s)){
                PrintWriter writer=new PrintWriter(socket.getOutputStream());
                writer.println("用户"+socket.getPort()+"说:"+msg);
                writer.flush();
            }
        }
    }
}
