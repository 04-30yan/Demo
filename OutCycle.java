package interview;

//跳出循环的方法

public class OutCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] ={{1,2,3},{4,5,6,7},{9}}; 
		boolean found = false; 
		for(int i=0;i<arr.length&& !found;i++) {         
			for(int j=0;j<arr[i].length;j++){                
				System.out.println("i=" + i + ",j=" + j);                
				if(arr[i][j]  ==5) {                       
					found = true;                       
					break;                
					}         
				} 
			} 
	}

}
