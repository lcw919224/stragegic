package com.stragegic.web.controller.niodemo02;

import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;


public class Demo02 {

    //客户端
    @Test
    public void client() throws Exception {

        //1. 网络通道注册
        SocketChannel cChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8089));
        //2. 切换为非阻塞式
        cChannel.configureBlocking(false);
        //3. 设置缓冲区大小
        ByteBuffer buffer = ByteBuffer.allocate(102400);

        //4. 读取数据进入缓冲区
        String s = LocalDateTime.now().toString();
        buffer.put(s.getBytes());
        //5. 切换读写模式
        buffer.flip();
        //6. 写入数据通道
        cChannel.write(buffer);
        //7. 清空缓存区数据
        buffer.clear();

        //8. 关闭通道
        cChannel.close();
    }

    //服务端
    @Test
    public void service() throws Exception {
        //1. 获取通道  注册并绑定 new InetSocketAddress(8888)
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2. 切换非阻塞模式
        ssChannel.configureBlocking(false);
        //3. 绑定端口地址
        ssChannel.bind(new InetSocketAddress(8089));
        //4. 获取选择器
        Selector selector = Selector.open();
        //5. 通道注册到选择器  监听选择器的事件 key
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6. 循环式读取是否有 "就绪" 事件
        while (selector.select() > 0) {
            //7. 遍历选择器 获取当前所有的选择键(以就绪的事件)

            for (SelectionKey item : selector.keys()) {
                //8. 判断就绪的事件
                if (item.isAcceptable()) {
                    //9. "就绪"事件 建立连接
                    SocketChannel sChannel = ssChannel.accept();
                    if (Objects.nonNull(sChannel)) {
                        //10. 切换非阻塞模式
                        sChannel.configureBlocking(false);
                        //11. 将该通道注册到选择器上
                        sChannel.register(selector, SelectionKey.OP_READ);
                    }

                } else if (item.isReadable()) {
                    //12. 读事件 建立连接
                    SocketChannel sChannel = (SocketChannel) item.channel();
                    if (Objects.nonNull(sChannel)) {
                        //13. 创建缓冲区
                        ByteBuffer byteBuffer = ByteBuffer.allocate(102400);
                        int len = 0;
                        //14. 读取数据
                        while ((len = sChannel.read(byteBuffer)) > 0) {
                            //15. 切换读写模式
                            byteBuffer.flip();
                            //16. 打印数据
                            System.out.println(new String(byteBuffer.array(), 0, len));
                            //17. 清空缓冲区
                            byteBuffer.clear();
                        }
                    }
                }

            }
        }
    }

}
