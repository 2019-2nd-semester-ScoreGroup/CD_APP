package com.example.cdprojectalpha;

import java.net.Socket;

public class client extends Thread {
    Socket socket = null;
    String ip;
    int port;

    public void set_connect(String s, int i){
        ip = s;
        port = i;
    }

    public void run() {
        try {
            socket = new Socket(ip, port);
            MainActivity.connect = 1;
        } catch (Exception e) {
            MainActivity.connect = 0;
        }
    }
}
