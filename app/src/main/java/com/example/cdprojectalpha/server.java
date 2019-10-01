package com.example.cdprojectalpha;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String arg[])
    {
        Socket socket = null;                //Client와 통신하기 위한 Socket
        ServerSocket server_socket;  //서버 생성을 위한 ServerSocket
        server_socket = null;

        try{
            server_socket = new ServerSocket(8888);

        }catch(IOException e)
        {
            System.out.println("해당 포트가 열려있습니다.");
        }
        try {

            System.out.println("서버 오픈!!");
            socket = server_socket.accept();    //서버 생성 , Client 접속 대기
            System.out.println("OK");

            socket.close();
        }catch(IOException e){}
    }
}
