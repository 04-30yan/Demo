package interview;

//����switchʵ��ԭ��

public class TestSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mode = args[0]; 
		//ֻ�ܽ�������(byte,short,char,int,Integer)��enum��String
		switch (mode) { 
			//�ڲ���ʹ��hashcode()
			case "ACTIVE": 
				System.out.println("Application is running on Active mode"); 
			break; 
			case "PASSIVE": 
				System.out.println("Application is running on Passive mode"); 
			break; 
			case "SAFE": 
				System.out.println("Application is running on Safe mode"); 
		} 
	} 
}


