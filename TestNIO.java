package interview;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

//分析NIO工作原理
public class TestNIO {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:/极客网/作业/JAVA测试题.docx");
		FileOutputStream fos = new FileOutputStream("D:/NIO.docx");
		FileChannel readChannel = fis.getChannel();
		FileChannel writeChannel = fos.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while(true) {
			buffer.clear();
			if(readChannel.read(buffer) == -1) {
				break;
			}
			
			//将buffer的模式从写模式切换成读模式
			buffer.flip();
			
			writeChannel.write(buffer);
		}
		readChannel.close();
		writeChannel.close();
	}
}
