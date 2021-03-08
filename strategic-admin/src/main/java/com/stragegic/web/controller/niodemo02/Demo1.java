package com.stragegic.web.controller.niodemo02;


import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Demo1 {

    //客户端发送数据
    @Test
    public void client() throws Exception {
        //获取网络通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        //本地文件通道
        FileChannel fileChannel = FileChannel.open(Paths.get("D:\\1.mp4"), StandardOpenOption.READ);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024000);

        while (fileChannel.read(byteBuffer) != -1) {
            //切换flip状态
            byteBuffer.flip();
            //写入网络通道
            socketChannel.write(byteBuffer);
            //清空流数据
            byteBuffer.clear();
        }

        System.out.println(fileChannel);
        System.out.println(socketChannel);
        //关闭通道
        socketChannel.close();
        fileChannel.close();

    }

    //服务端接受数据
    @Test
    public void service() throws Exception {
        //获取网络通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8080));
        //获取
        SocketChannel socketChannel = serverSocketChannel.accept();
        //获取文件通道
        FileChannel fileChannel = FileChannel.open(Paths.get("D:\\2.mp4"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
        //缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (socketChannel.read(byteBuffer) != -1) {
            //切换缓存区状态
            byteBuffer.flip();
            //写入通道
            fileChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        //释放自愿
        serverSocketChannel.close();
        fileChannel.close();
        socketChannel.close();

    }
}
