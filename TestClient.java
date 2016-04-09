package interview;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

//模拟客户端请求服务器端，TestServer

public class TestClient {
	
	private SocketChannel sChannel = null;
	private Selector selector = null;
	
	private ByteBuffer sendBuffer = ByteBuffer.wrap("Client data".getBytes());
	private ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestClient tClient = new TestClient();
		try {
			tClient.work(8085);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void work(int port) throws IOException {
		sChannel = SocketChannel.open();
		selector = Selector.open();
		sChannel.configureBlocking(false);
		sChannel.connect(new InetSocketAddress("localhost", 8080));
		sChannel.register(selector, SelectionKey.OP_CONNECT|SelectionKey.OP_READ|SelectionKey.OP_WRITE);
		while(true) {
			if(selector.select() == 0) {
				continue;
			}
			Iterator<SelectionKey> sKeys = selector.selectedKeys().iterator();
			while(sKeys.hasNext()) {
				SelectionKey key = sKeys.next();
				sKeys.remove();
				sChannel = (SocketChannel) key.channel();
				
				if(key.isConnectable()) {
					if(sChannel.isConnectionPending()) {
						sChannel.finishConnect();
						System.out.println("完成连接");
						sChannel.write(sendBuffer);
						sChannel.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
					}
					else if(key.isReadable()) {
						receiveBuffer.clear();
						sChannel.read(receiveBuffer);
						System.out.println(new String(receiveBuffer.array()));
					}
					else if(key.isWritable()) {
						receiveBuffer.flip();
					    sendBuffer.flip();
					    sChannel.write(sendBuffer);
					}
				}
				
			}
		}
	}

}
