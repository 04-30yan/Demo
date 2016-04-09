package interview;

//分析switch实现原理

public class TestSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mode = args[0]; 
		//只能接收整型(byte,short,char,int,Integer)和enum、String
		switch (mode) { 
			//内部是使用hashcode()
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


