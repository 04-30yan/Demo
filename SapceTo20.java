package interview;
import java.util.*;

//将字符串中的空格转换成20%

public class SapceTo20 {
	/*
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int length = str.length();
		char[] strChars = new char[length * 3];
		strChars = str.toCharArray();
		String strNew = new String(strChars);
		//replace()是基于字符串的
		//replaceAll()是基于正则表达式的，第一个参数是正则表达式，
		//如果不是正则表达式就和replace是一样的
		strNew = strNew.replaceAll(" ", "%20");
		for (int i = 0; i < strNew.length(); i++) {
			System.out.printf("%c", strNew.charAt(i));
	    }
	}
	*/
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int space = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ')
				space++;
		}
		int newLength = str.length() + space * 2;
		char[] strChars = new char[newLength];
		for(int i = str.length() - 1; i >= 0; i--) {
			if(str.charAt(i) == ' ') {
				strChars[newLength - 1] = '0';
			    strChars[newLength - 2] = '2';
			    strChars[newLength - 3] = '%';
			    newLength = newLength - 3;
			}else {
				strChars[newLength - 1] = str.charAt(i);
				newLength = newLength - 1;
			}
		}
			System.out.println(Arrays.toString(strChars));
	} 
}
