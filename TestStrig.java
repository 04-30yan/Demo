package interview;

//分析字符换源码

public class TestStrig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = new String("ok");
		String s12 = new String("ok");
		String s2 = "ok";
		String s22 = "ok";
		s1 = s12;
		StringBuilder s1b = new StringBuilder("ok");
		StringBuilder s2b = new StringBuilder("s2");
		//将每个字符串中的每个字符装换成相对应的值+h*31
		System.out.println(s1.hashCode());//3548
		System.out.println(s2.hashCode());//3548
		System.out.println(s22.hashCode());//3548
		System.out.println(s2 == s22);//true
		System.out.println(s2.equals(s22));
		//只有字符串常量才共享地址，字符串变量相当于对象变量，因此不能共享
//		System.out.println(s1 == s2);//false
//		System.out.println(s1b == s2b);//false
		System.out.println(s1 == s12);//false
	}

}
