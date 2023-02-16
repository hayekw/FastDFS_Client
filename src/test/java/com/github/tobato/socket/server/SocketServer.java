package com.github.tobato.socket.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    /**
     * 日志
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(SocketServer.class);

    public void service() {
        int i = 0;
        ServerSocket serverSocket;
        try {
            int port = 22122;
            serverSocket = new ServerSocket(port);
        } catch (BindException e) {
            LOGGER.error("端口绑定错误", e.getCause());
            throw new RuntimeException("端口已经被绑定");
        } catch (IOException e1) {
            LOGGER.error("其他错误", e1.getCause());
            throw new RuntimeException(e1.getMessage());
        }

        while (true) {
            Socket socket;
            try {
                i++;
                socket = serverSocket.accept(); // 主线程获取客户端连接
                LOGGER.debug("第{}个客户端成功连接！", i);
                Thread workThread = new Thread(new Handler(socket)); // 创建线程
                workThread.start(); // 启动线程
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] agrs) {
        LOGGER.debug("正在启动服务..");
        SocketServer server = new SocketServer();
        LOGGER.debug("服务已经启动完成");
        server.service();
    }
}
