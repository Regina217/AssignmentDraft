package application;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;

public class Server {
    ServerSocket serverSocket;
    Queue<Socket> playingSevers;
    Queue<Socket> waitingServers;
    public Server(){
       try {
           while (true){
               serverSocket=new ServerSocket(10086);
               Socket server=serverSocket.accept();
               waitingServers.offer(server);//waiting queue
               match(server);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   public void match(Socket socket){
       if(waitingServers.size()==1){
           send(socket,"Wait");
       }
       if (waitingServers.size()==2){
           Socket opponent=waitingServers.poll();
           waitingServers.poll();
           send(opponent,"match");
           send(socket,"match");
           ServerThread serverThread=new ServerThread(serverSocket,opponent,socket);
           serverThread.start();
       }
       }

       //有可能有bug
   public void send(Socket socket,String s){
       try {
           OutputStream os=socket.getOutputStream();
           DataOutputStream out=new DataOutputStream(os);
           out.writeUTF(s);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
    class ServerThread extends Thread{
        ServerSocket server;
        Socket player1;
        Socket player2;
        public ServerThread(ServerSocket server,Socket p1,Socket p2){
            this.server=server;
            player1=p1;
            player2=p2;
        }
        @Override
        public void run() {
            super.run();

        }
    }
   // state:
    // 1 Please wait your opponent... 2 successfully match!

    //wait for new players
    //match
    //no match then inform
    //track and inform lose or win

//  计数器记录奇偶来通知等待和匹配
//  不停地访问输赢状态
public static void main(String[] args) {
    Server server=new Server();
}
}
