package interview;

//java编写一个二叉树 实现 查找，前序，中序，后序遍历

public class BinaryNode {    
	public int value;   
	public BinaryNode left;    
	public BinaryNode right;    
	public void store(int value) {       
		if(value < this.value) {        
			if(left == null) {          
				left = new BinaryNode();      
				left.value = value;        
				} else  {  
					left.store(value);   
					}      
		}      
	    else if(value > this.value) {    
			if(right == null) {         
				right = new BinaryNode(); 
                right.value = value;         
             } else {   
            	 right.store(value);        
            }          
		}   
	}         
	public boolean find(int value) {         
		if(value == this.value) {       
			return true;   
		} else if(value > this.value) {           
			if(right == null)
				return false;     
			return right.find(value);        
		}else {  
			if(left == null)
				return false;        
		return left.find(value);       
		}     
	}        
	public void preList() {  
		System.out.print(this.value+ ","); 
		if(left != null)
			left.preList();       
        if(right != null)
    	   right.preList();    
    }    
	
	public void middleList() {    
		if(left != null)
			left.preList();     
		System.out.print(this.value+ ",");       
		if(right != null)
			right.preList();         
	}    
	
	public void afterList() {     
		if(left != null)
			left.preList();      
		if(right != null)
			right.preList();     
		System.out.print(this.value+ ",");       
	}   
	
	public static void main(String [] args) {       
		int [] data = new int[20];     
		for(int i = 0; i < data.length; i++) {     
			data[i] = (int)(Math.random() * 100) + 1;       
			System.out.print(data[i] + ",");     
		}        
		System.out.println();             
		BinaryNode root = new BinaryNode();      
		root.value = data[0];       
		for(int i = 1; i < data.length; i++) {        
			root.store(data[i]); 
       }             
		root.find(data[19]);          
		root.preList();     
		System.out.println();     
		root.middleList();     
		System.out.println();            
		root.afterList();   
		} 
	} 