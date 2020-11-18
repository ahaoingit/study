package com.nio.channel;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * TODO
 *
 * @author ahao 2019-08-29
 */
public class ChannelDemo {
    /**
     * 向文件写入数据
     * @throws IOException
     */
    @Test
    public void channelOperationWrite() throws IOException {
        String str = "lalal赵志豪";
        FileOutputStream fileOutputStream = new FileOutputStream("ahao.tex");
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());
        buffer.flip();

        channel.write(buffer);
        fileOutputStream.close();
        fileOutputStream.close();

    }

    /**
     * 文件的读取
     */
    @Test
    public void channelOperationRead() throws IOException {
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream = new FileInputStream("ahao.tex");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();
//        while (buffer.hasRemaining()) {
//            byte b = buffer.get();
//            sb.append((char) b);
//        }
        System.out.println(new String(buffer.array()));
        fileInputStream.close();
    }

    /**
     * 文件拷贝
     * @throws IOException
     */
    @Test
    public void channelOperationCopy() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("img.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("img2.jpg");
        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true){
            /**
             * 为什么要清空
             *  通道的读取都会改变 position的位置
             *  每一次循环 最后的write操作之后position处于buffer最后一个数据的下标所以要重置所有的标志为
             *
             *  为什么buffer.flip不行
             *     第一次循环position就是0 此时flip limit就是0 然后read 只能是0
             */
            buffer.clear();//⭐⭐⭐⭐⭐⭐?
            int read = inputStreamChannel.read(buffer);
            System.out.println(read);
            if (read == -1) {
                break;
            }
            buffer.flip();
            outputStreamChannel.write(buffer);
        }
        outputStreamChannel.close();
        inputStreamChannel.close();
    }

    /**
     * 文件copy
     */
    @Test
    public void channelCopyTransform() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("img.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("img3.jpg");
        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        outputStreamChannel.transferFrom(inputStreamChannel,0,inputStreamChannel.size());

        outputStreamChannel.close();
        inputStreamChannel.close();
        fileOutputStream.close();
        fileInputStream.close();

    }
}
