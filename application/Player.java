package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Player{
    Socket socket;
    public Player(){
        try {
            socket=new Socket("localhost",10086);
            OutputStream os=socket.getOutputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    class readServerThread extends Thread{
        InputStream is;
        {
            try {
                is = socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //connect
    //GUI
  //play
  //lose or win or tie
    public static void main(String[] args) {
        Player player=new Player();
    }
}
