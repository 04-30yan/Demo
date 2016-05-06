package interview;

import java.util.Arrays;

//已知传递一个对象或者数组时实际传递的是对象引用的拷贝
//测试传一个基本类型的数据可不可以改变他的值

public class TestValueOrQuote {
	static int b = 0;
	public static void main(String[] args) {
		int a = 10;
		int[] as = {1, 6, 3, 4};
		change(a);
		System.out.println(a);//10->说明不可以
		
		changeB(b);
		System.out.println(b);//0->说明不可以
		
		changeAs(as);
		System.out.println(Arrays.toString(as));//[3, 3, 3, 3]->说明数组是可以改变值的
		//因为数组实际上也是通过new关键字来分配内存，所以返回的是入口的地址，既然存储的是地址就和对象是一样的，如果需要只是拷贝其值就是用copyOf()
	}
	public static void change(int a) {
		a = 20;
	}
	public static void changeB(int b) {
		b = 20;
	}
	public static void changeAs(int[] as) {
		for(int i = 0; i < as.length; i++) {
			as[i] = 3;
		}
	}
}
