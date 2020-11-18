package com.ahao.netty.NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ahao
 */
public class NioFileChannel2 {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate((int) file.length());
        int read = channel.read(allocate);
        System.out.println(new String(allocate.array(),0,read));
        fileInputStream.close();
    }
}
