package com.ahao.netty.NIO;

import java.nio.IntBuffer;
import java.nio.channels.ServerSocketChannel;

/**
 * @author ahao
 */
public class NioBuffer {
    public static void main(String[] args) {
        //可以存放5个int
        IntBuffer allocate = IntBuffer.allocate(5);
        //存放数据
        allocate.put(50);
        allocate.put(1);
        allocate.put(22);
        for (int i = 3;i<allocate.capacity();i++){
            allocate.put(i*3);
        }

        //读写切换
        allocate.flip();
        while (allocate.hasRemaining()){
            System.out.println(allocate.get());
        }
    }
}
