package com.nio.buffer;

import org.junit.Test;

import java.nio.IntBuffer;

/**
 * TODO
 *
 * @author ahao 2019-08-29
 */
public class BufferDemo {

    @Test
    public void BufferOperation() {
        /**
         * mark=-1
         * position=0
         * limit=10
         * capacity=10
         */
        IntBuffer allocate = IntBuffer.allocate(10);

        /**
         * 数据的填充
         */
        for (int i =0;i<4;++i) {
            /*
                put 会使 position++
             */
            allocate.put(i);
        }
        /**
         * limit = position
         * position=0;
         */
        allocate.flip();

        /**
         * 读取
         * hasRemaining   return position < limit
         */

        while (allocate.hasRemaining()) {
            //get position++
            allocate.get();
        }

        /**
         * 缓冲区的清除 只是重置标志位 数据并未清除
         * position = 0;
         * limit = capacity;
         * mark = -1;
         */
        allocate.clear();
        int i = allocate.get(2);
        System.out.println(i);
    }
}
