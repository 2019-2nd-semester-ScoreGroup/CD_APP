package com.example.cdprojectalpha;

import java.io.*;
import java.net.Socket;

public class client extends Thread {
    Socket socket = null;
    String ip, S_msg = "start";
    int port, S_state = 1;
    BufferedReader in = null;        //Server로부터 데이터를 읽어들이기 위한 입력스트림
    PrintWriter out = null;            //서버로 내보내기 위한 출력 스트림

    public void Set_IpPort(String Server_IP, int Server_PORT){
        ip = Server_IP;
        port = Server_PORT;
    }

    public void Connection(){
        try {
            socket = new Socket(ip, port);
            option.connect = 1;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
        } catch (Exception e) {
            option.connect = 0;
        }
    }

    public void Read(){
        String str = null;            //서버로부터 되돌아오는 데이터 읽어들임
        try {
            str = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("서버로부터 되돌아온 메세지 : " + str);
    }

    public void SendMsg(){
        if(S_state == 1){
            try {
                out.println(S_msg);                        //서버로 데이터 전송
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            S_state = 0;
        }else
            return;
    }

    public void Msg_Event(String msg){
        S_msg = msg;
        S_state = 1;
    }

    public void run() {
        Connection();
        while(true){
            SendMsg();
        }
    }
}
