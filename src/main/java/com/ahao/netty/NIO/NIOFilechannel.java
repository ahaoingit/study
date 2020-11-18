package com.ahao.netty.NIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ahao
 */
public class NIOFilechannel {
    public static void main(String[] args) throws IOException {
        String str = "ahao";
        //创建输出流
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        //获取对应channel
        FileChannel channel = fileOutputStream.getChannel();
        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //把str 放入bytebuffer
        byteBuffer.put(str.getBytes());
        //反转buffer
        byteBuffer.flip();
        //将此buffer 写入channel
        channel.write(byteBuffer);
        fileOutputStream.close();


    }
}
