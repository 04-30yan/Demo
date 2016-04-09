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
		System.out.println("����������");
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
  
        // ���Դ˼���ͨ���Ƿ���׼���ý����µ��׽������ӡ�  
        if (key.isAcceptable())  
        {  
            // ����Ϊ֮�����˼���ͨ����  
            server = (ServerSocketChannel) key.channel();  
  
            // �˷������ص��׽���ͨ��������У�����������ģʽ��  
            client = server.accept();  
            // ����Ϊ������  
            client.configureBlocking(false);  
            // ע�ᵽselector���ȴ�����  
            client.register(selector, SelectionKey.OP_READ  
                    | SelectionKey.OP_WRITE);  
        }  
        else  
            if (key.isReadable())  
            {  
                // ����Ϊ֮�����˼���ͨ����  
                client = (SocketChannel) key.channel();  
                // ������������Ա��´ζ�ȡ  
                receiveBuffer.clear();  
                // ��ȡ�����������������ݵ���������  
                client.read(receiveBuffer);  
  
                System.out.println(new String(receiveBuffer.array()));  
                  
                key.interestOps(SelectionKey.OP_WRITE);  
            }  
            else  
                if (key.isWritable())  
                {  
                    // ������������Ա��´�д��  
                    sendBuffer.flip();  
                    // ����Ϊ֮�����˼���ͨ����  
                    client = (SocketChannel) key.channel();  
  
                    // �����ͨ��  
                    client.write(sendBuffer);  
                      
                    key.interestOps(SelectionKey.OP_READ);  
                }  
    }  
}
