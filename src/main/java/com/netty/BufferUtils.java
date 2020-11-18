package com.netty;

import java.nio.ByteBuffer;

/**
 * TODO
 *
 * @author ahao 2020-08-12
 */
public class BufferUtils {
    public static ByteBuffer getBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i=0; i<buffer.capacity() - 2;++i){
            buffer.put((byte) i);
        }
        buffer.flip();
        return buffer;
    }

    public static void printBuffer(ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
