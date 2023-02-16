package com.github.tobato.socket.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {

    public static void main(String[] args) throws IOException {

        Socket s = new Socket("192.168.99.100", 22122);

        OutputStream out = s.getOutputStream();

        DataOutputStream dout = new DataOutputStream(out);

        // dout.writeUTF("oftenlin");

        InputStream in = s.getInputStream();
        DataInputStream din = new DataInputStream(in);

        String st = din.readUTF();

        in.close();
        out.close();
        s.close();
    }
}
