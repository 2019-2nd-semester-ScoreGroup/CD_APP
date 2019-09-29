package com.example.cdprojectalpha;

import java.io.IOException;
import java.net.Socket;

public class client {
    public static Socket socket = null;            //Server와 통신하기 위한 Socket

    public void server_test(String ip)
    {
        try {
            socket = new Socket(ip, 8888);
            MainActivity.connect = 1;
        }catch(IOException e) {
            MainActivity.connect = 0;
        }
    }
}
