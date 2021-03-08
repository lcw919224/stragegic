package com.stragegic.web.controller.niodemo02;

import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Date;
import java.util.Iterator;


public class Demo03 {

    @Test
    public void client() throws Exception {
        //1. 创建通道
        DatagramChannel channel = DatagramChannel.open();
        //2. 切换非阻塞模式
        channel.configureBlocking(false);
        //3. 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10240);
        //4. 数据添加到缓冲区
        buffer.put(new Date().toString().getBytes());
        //5. 读写切换
        buffer.flip();
        //6. 发送数据
        channel.send(buffer, new InetSocketAddress("127.0.0.1", 8087));
        buffer.clear();

        channel.close();
    }

    @Test
    public void service() throws Exception {
        //1. 创建通道
        DatagramChannel datagramChannel = DatagramChannel.open();
        //2. 切换非阻塞模式
        datagramChannel.configureBlocking(false);
        //3. 端口绑定
        datagramChannel.bind(new InetSocketAddress(8087));
        //4. 获取选择器
        Selector selector = Selector.open();
        //5. 将通道注册到选择器上 选择器 监听事件SelectionKey
        datagramChannel.register(selector, SelectionKey.OP_READ);
        //6. 循环遍历监听选择器上 就绪 的事件
        while (selector.select() > 0) {

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isReadable()) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    datagramChannel.receive(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(), 0, buffer.limit()));
                    buffer.clear();
                }
            }
            iterator.remove();
        }

    }
}
