package interview;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;


/**
  1.RecursiveTask<Integer>有返回值和RecursiveAction<T>无返回值，
       但是均实现于ForkJionTask
  
  2.通过ForkJionPool   submit() 将 ForkJoinTask 类的对象提交给 ForkJoinPool，
    ForkJoinPool 将立刻开始执行 ForkJoinTask
    ForkJoinPool extends AbstractExecutorService
          通过工作线程
    public static interface ForkJoinWorkerThreadFactory {
       
          Returns a new worker thread operating in the given pool.
         
         @param pool the pool this thread works in
         @throws NullPointerException if the pool is null
         
         //ForkJoinWorkerThread extends Thread
        //内部使用数组来存放任务,ForkJoinTask<?>[] queue 
        public ForkJoinWorkerThread newThread(ForkJoinPool pool);
        
    }
 */
public class CountTwoForkJion extends RecursiveTask<Integer> {
		private static final int THRESHOLD = 2;// 阈值
		private int start;
		private int end;
		public CountTwoForkJion(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		protected Integer compute() {
			int sum = 0;

			// 如果任务足够小就计算任务
			boolean canCompute = (end - start) <= THRESHOLD;
			if (canCompute) {
				for (int i = start; i <= end; i++) {
					sum += i;
				}
			} else {
	
				// 如果任务大于阀值，就分裂成两个子任务计算
				int middle = (start + end) / 2;
				CountTwoForkJion leftTask = new CountTwoForkJion(start, middle);
				CountTwoForkJion rightTask = new CountTwoForkJion(middle + 1, end);
				
				//执行子任务
				//w.pushTask(task);放到ForkJionWorkThread中的ForkJionTask的queue中，这个就相当于线程池的任务队列
				//然后调用ForkJionPool的signalWork()唤醒或者创建一个线程来异步执行这个任务，
				leftTask.fork();
				rightTask.fork();
				
				//等待子任务执行完，并得到其结果
				int leftResult=leftTask.join();
				int rightResult=rightTask.join();
				
				//合并子任务
				sum = leftResult + rightResult;
			}
			return sum;
		}
		public static void main(String[] args) {
			
			//默认创建一个线程数等于cpu数目的线程池
			ForkJoinPool forkJoinPool = new ForkJoinPool();
			CountTwoForkJion task = new CountTwoForkJion(1, 4);
			
			// 执行一个任务  forkOrSubmit(task);
			Future<Integer> result = forkJoinPool.submit(task);
			try {
				System.out.println(result.get());
			} catch (InterruptedException e) {
			} catch (ExecutionException e) {
			}
		}
}
