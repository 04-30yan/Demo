package interview;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class TestServer {

	private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
	private ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
	
	private int port = 0;
	
	private ServerSocketChannel ssChannel = null;
	private Selector selector = null;
	
	TestServer(int port) throws IOException {
		ServerSocketChannel ssChannel1 = ServerSocketChannel.open();
		ssChannel.configureBlocking(false);
		ServerSocket serverSocket = ssChannel.socket();
		serverSocket.bind(new InetSocketAddress(port));
		selector = Selector.open();
		ssChannel1.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("服务器启动");
		sendBuffer.put("server data".getBytes());
		
	}
	private void listen() throws IOException {
		while(true) {
			Iterator<SelectionKey> sKeys = selector.keys().iterator();
			while(sKeys.hasNext()) {
				SelectionKey key = sKeys.next();
				sKeys.remove();
				work(key);
			}
		
		}
	}
	public static void main(String[] args) throws IOException{
		TestServer tServer = new TestServer(8080);
		tServer.listen();
	}
	
	private void work(SelectionKey key) throws IOException {
		ServerSocketChannel server = null;  
        SocketChannel client = null;  
        String receiveText;  
        String sendText;  
        int count = 0;  
  
        // 测试此键的通道是否已准备好接受新的套接字连接。  
        if (key.isAcceptable())  
        {  
            // 返回为之创建此键的通道。  
            server = (ServerSocketChannel) key.channel();  
  
            // 此方法返回的套接字通道（如果有）将处于阻塞模式。  
            client = server.accept();  
            // 配置为非阻塞  
            client.configureBlocking(false);  
            // 注册到selector，等待连接  
            client.register(selector, SelectionKey.OP_READ  
                    | SelectionKey.OP_WRITE);  
        }  
        else  
            if (key.isReadable())  
            {  
                // 返回为之创建此键的通道。  
                client = (SocketChannel) key.channel();  
                // 将缓冲区清空以备下次读取  
                receiveBuffer.clear();  
                // 读取服务器发送来的数据到缓冲区中  
                client.read(receiveBuffer);  
  
                System.out.println(new String(receiveBuffer.array()));  
                  
                key.interestOps(SelectionKey.OP_WRITE);  
            }  
            else  
                if (key.isWritable())  
                {  
                    // 将缓冲区清空以备下次写入  
                    sendBuffer.flip();  
                    // 返回为之创建此键的通道。  
                    client = (SocketChannel) key.channel();  
  
                    // 输出到通道  
                    client.write(sendBuffer);  
                      
                    key.interestOps(SelectionKey.OP_READ);  
                }  
    }  
}
