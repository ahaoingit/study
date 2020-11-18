package com.ahao.netty.NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ahao
 */
public class ChannelCopyTransferFrom {
    public static void main(String[] args) throws IOException {
        //transferFrom 拷贝通道
        FileInputStream fileInputStream = new FileInputStream("img.jpg");
        FileChannel channel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("imgcpto.jpg");
        FileChannel channel1 = fileOutputStream.getChannel();
       //channel1.transferFrom(channel,0,channel.size());
        channel.transferTo(0,channel.size(),channel1);
        fileOutputStream.close();
        fileInputStream.close();
    }
}
