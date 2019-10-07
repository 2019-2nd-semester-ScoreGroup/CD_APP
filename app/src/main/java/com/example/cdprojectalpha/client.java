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
            option.connect = 1;
        } catch (Exception e) {
            option.connect = 0;
        }
    }
}
