package com.ahao.netty.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ahao
 */
public class BIOServer {

    /**
     * 思路
     * 1.创建线程池
     * 2.如果有连接，就创建一个线程，与之通讯
     */

    public static void main(String[] args) throws IOException {

        ExecutorService executorPool= Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("启动");
        while (true){
            final Socket accept = serverSocket.accept();
            System.out.println("连接到客户端");
            executorPool.execute(new Runnable() {
                @Override
                public void run() {
                    handle(accept);
                }
            });
        }
    }
    public static void handle(Socket socket){
        byte[] bytes= new byte[1024];
        OutputStream outputStream = null;
        try {
            System.out.println("线程 id="+Thread.currentThread().getId()+":"+Thread.currentThread().getName());
            InputStream inputStream = socket.getInputStream();
            outputStream=socket.getOutputStream();
            //循环读取客户端数据
            while (true){
                int read = inputStream.read(bytes);
                if (read != -1){
                    System.out.println(new String(bytes,0,read));
                }else {
                    System.out.println("通讯结束");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关资源
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
