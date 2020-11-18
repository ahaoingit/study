package com.netty;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import static com.netty.BufferUtils.getBuffer;
import static com.netty.BufferUtils.printBuffer;

/**
 * TODO
 *
 * @author ahao 2020-08-12
 */
public class BufferDemo1 {
    @Test
    public  void test1() {
        IntBuffer allocate = IntBuffer.allocate(10);
        for (int i=0; i<allocate.capacity(); ++i) {
            allocate.put(i);
        }
        System.out.println(allocate.position(0));
        allocate.flip();
        while (allocate.hasRemaining()) {
            System.out.println(allocate.get());
        }
    }
    @Test
    public void fileOperating() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(10);
        int read = channel.read(allocate);
        System.out.println(read);
        allocate.position();
        System.out.println(allocate.position());
    }

    /**
     * 缓冲区切片
     * 子缓冲与父缓冲 共享一个缓冲区间 类似于视图
     * ++
     */
    @Test
    public void shareBufferBySlice() throws IOException {
        ByteBuffer buffer = getBuffer();

        buffer.position(5);
        buffer.limit(8);
        //截取的子buffer 不包含头即第5个不包含 包含尾部即包含第8个  (5,8]
        ByteBuffer slice = buffer.slice();

        for (int i = 1; i <= slice.capacity(); ++i) {
            slice.put((byte) (i*10));
        }
        buffer.clear();
        printBuffer(buffer);
    }

    /**
     * 只读缓冲区的创建
     */
    @Test
    public void createReadOnlyBuffer() {
        ByteBuffer buffer = getBuffer();
        //于buffer共享数据 是只读的
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        //更改会有  ReadOnlyBufferException异常
        //readOnlyBuffer.put((byte) 1);
    }

    public void createDirectBuffer() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
    }
    @Test
    public void mappedBuffer() throws IOException {
        RandomAccessFile rw = new RandomAccessFile("D:\\studyworkspace\\src\\main\\java\\com\\netty\\test.txt", "rw");
        FileChannel fileChannel = rw.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        mappedByteBuffer.put(0,(byte) 88);
        mappedByteBuffer.put(1,(byte) 97);
        rw.close();
    }
}
