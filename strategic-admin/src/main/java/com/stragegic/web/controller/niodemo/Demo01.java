package com.stragegic.web.controller.niodemo;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Demo01 {

    //利用通道完成文件读写  (非直接缓冲区)
    @Test
    public void tst01() throws Exception {

        //读取文件
        FileInputStream inputStream = new FileInputStream("D:\\1.mp4");
        FileOutputStream outputStream = new FileOutputStream("D:\\2.mp4");

        //获取通道
        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();

        //获取缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //读取流通道到缓存区
        while (inputStreamChannel.read(byteBuffer) != -1) {
            //读写切换
            byteBuffer.flip();
            //通过out通道写
            outputStreamChannel.write(byteBuffer);
            //清空缓存区
            byteBuffer.clear();
        }
        inputStream.close();
        outputStream.close();
        inputStreamChannel.close();
        outputStreamChannel.close();
    }


    // 使用直接缓存进行文件读取(内存映射文件)
    @Test
    public void test02() throws Exception {
        //创建管道 指定管道类型 读取文件
        FileChannel readChannel = FileChannel.open(Paths.get("D:\\1.mp4"), StandardOpenOption.READ);
        FileChannel writeChannel = FileChannel.open(Paths.get("D:\\2.mp4"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        //映射物理内存区域
        MappedByteBuffer readMap = readChannel.map(FileChannel.MapMode.READ_ONLY, 0, readChannel.size());
        MappedByteBuffer writeMap = writeChannel.map(FileChannel.MapMode.READ_WRITE, 0, readChannel.size());

        //读写
        byte[] dst = new byte[readMap.limit()];
        readMap.get(dst);
        writeMap.put(dst);

        //关闭流
        readChannel.close();
        writeChannel.close();
    }

    // 使用直接缓存进行文件读取(内存映射文件)
    @Test
    public void test03() throws Exception {
        //创建管道 指定管道类型 读取文件
        FileChannel readChannel = FileChannel.open(Paths.get("D:\\1.mp4"), StandardOpenOption.READ);
        FileChannel writeChannel = FileChannel.open(Paths.get("D:\\2.mp4"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        readChannel.transferTo(0, readChannel.size(), writeChannel);
        //关闭流
        readChannel.close();
        writeChannel.close();
    }

    //聚集写入
    @Test
    public void test04() throws Exception {
        RandomAccessFile readFile = new RandomAccessFile("D:\\1.txt", "rw");
        FileChannel readFileChannel = readFile.getChannel();

        ByteBuffer bus1 = ByteBuffer.allocate(1024);
        ByteBuffer bus2 = ByteBuffer.allocate(102400);
        ByteBuffer[] bus = {bus1, bus2};
        readFileChannel.read(bus);

        for (ByteBuffer byteBuffer : bus) {
            byteBuffer.flip();
        }

        RandomAccessFile writeFile = new RandomAccessFile("D:\\2.txt", "rw");
        FileChannel writeFileChannel = writeFile.getChannel();
        writeFileChannel.write(bus);

    }

    //字符集 编码与解码
    @Test
    public void test05() throws Exception {
        Charset ce = Charset.forName("gbk");

        CharsetEncoder encoder = ce.newEncoder();
        CharsetDecoder decoder = ce.newDecoder();

        CharBuffer buffer = CharBuffer.allocate(1024);
        buffer.put("测试编码");
        buffer.flip();

        //编码
        ByteBuffer encode = encoder.encode(buffer);
        System.out.println(encode);
        //解码
        CharBuffer decode = decoder.decode(encode);
        System.out.println(decode);

    }

}
