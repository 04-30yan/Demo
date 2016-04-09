package interview;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

//����NIO����ԭ��
public class TestNIO {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:/������/��ҵ/JAVA������.docx");
		FileOutputStream fos = new FileOutputStream("D:/NIO.docx");
		FileChannel readChannel = fis.getChannel();
		FileChannel writeChannel = fos.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while(true) {
			buffer.clear();
			if(readChannel.read(buffer) == -1) {
				break;
			}
			
			//��buffer��ģʽ��дģʽ�л��ɶ�ģʽ
			buffer.flip();
			
			writeChannel.write(buffer);
		}
		readChannel.close();
		writeChannel.close();
	}
}
