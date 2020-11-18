package com.ahao.netty.NIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ahao
 */
public class ChannelCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        FileChannel channel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("test2.txt");
        FileChannel channel1 = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (true){
            //一定要复位,pos和lim相等会导致read为0
            byteBuffer.clear();
            int read = channel.read(byteBuffer);
            if (read ==-1){
                break;
            }
            //一定要反转
            byteBuffer.flip();
            channel1.write(byteBuffer);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }
}