package interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//控制多线程运行的顺序，子线程运行10次，父线程运行100次

public class Son10Father100 {
			private static Lock lock = new ReentrantLock();        
			private static Condition subThreadCondition = lock.newCondition();        
			private static boolean bBhouldSubThread = true;        
			public static void main(String[] args) {               
				ExecutorService threadPool = Executors.newFixedThreadPool(3);  
				threadPool.execute(new Runnable() {                     
					public void run() {                             
						for(int i = 0; i < 50; i++) {                                    
							lock.lock();                                                                    
							try {
								if(!bBhouldSubThread)                                                  
									subThreadCondition.await();                                           
								for(int j = 0; j < 10; j++) {                                                  
									System.out.println(Thread.currentThread().getName()+ ",j=" + j +"i=" +i);                                         
								} 
									bBhouldSubThread = true;                                           
									subThreadCondition.signal(); 
								}catch(Exception e) {                                                                           
					 
								}finally {                                           
									lock.unlock(); 
								}                           
						}                                    
					}
				});               
				threadPool.shutdown();              
				for(int i = 0; i < 50; i++) {      
					lock.lock();                                                            
					try                          
					{                                        
						if(bBhouldSubThread)                                                
							subThreadCondition.await();                                                                                      
						for(int j = 0; j < 100; j++) {          
								System.out.println(Thread.currentThread().getName()+ ",j=" + j);                     
						}                                    
						bBhouldSubThread = false;                                   
						subThreadCondition.signal();                                                       
						}catch(Exception e) {                     
							
						} 
		            finally {                                   
		            	lock.unlock();                        
		            }                                           
				}      
			}
}
