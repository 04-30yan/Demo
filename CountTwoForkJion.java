package interview;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;


/**
  1.RecursiveTask<Integer>�з���ֵ��RecursiveAction<T>�޷���ֵ��
       ���Ǿ�ʵ����ForkJionTask
  
  2.ͨ��ForkJionPool   submit() �� ForkJoinTask ��Ķ����ύ�� ForkJoinPool��
    ForkJoinPool �����̿�ʼִ�� ForkJoinTask
    ForkJoinPool extends AbstractExecutorService
          ͨ�������߳�
    public static interface ForkJoinWorkerThreadFactory {
       
          Returns a new worker thread operating in the given pool.
         
         @param pool the pool this thread works in
         @throws NullPointerException if the pool is null
         
         //ForkJoinWorkerThread extends Thread
        //�ڲ�ʹ���������������,ForkJoinTask<?>[] queue 
        public ForkJoinWorkerThread newThread(ForkJoinPool pool);
        
    }
 */
public class CountTwoForkJion extends RecursiveTask<Integer> {
		private static final int THRESHOLD = 2;// ��ֵ
		private int start;
		private int end;
		public CountTwoForkJion(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		protected Integer compute() {
			int sum = 0;

			// ��������㹻С�ͼ�������
			boolean canCompute = (end - start) <= THRESHOLD;
			if (canCompute) {
				for (int i = start; i <= end; i++) {
					sum += i;
				}
			} else {
	
				// ���������ڷ�ֵ���ͷ��ѳ��������������
				int middle = (start + end) / 2;
				CountTwoForkJion leftTask = new CountTwoForkJion(start, middle);
				CountTwoForkJion rightTask = new CountTwoForkJion(middle + 1, end);
				
				//ִ��������
				//w.pushTask(task);�ŵ�ForkJionWorkThread�е�ForkJionTask��queue�У�������൱���̳߳ص��������
				//Ȼ�����ForkJionPool��signalWork()���ѻ��ߴ���һ���߳����첽ִ���������
				leftTask.fork();
				rightTask.fork();
				
				//�ȴ�������ִ���꣬���õ�����
				int leftResult=leftTask.join();
				int rightResult=rightTask.join();
				
				//�ϲ�������
				sum = leftResult + rightResult;
			}
			return sum;
		}
		public static void main(String[] args) {
			
			//Ĭ�ϴ���һ���߳�������cpu��Ŀ���̳߳�
			ForkJoinPool forkJoinPool = new ForkJoinPool();
			CountTwoForkJion task = new CountTwoForkJion(1, 4);
			
			// ִ��һ������  forkOrSubmit(task);
			Future<Integer> result = forkJoinPool.submit(task);
			try {
				System.out.println(result.get());
			} catch (InterruptedException e) {
			} catch (ExecutionException e) {
			}
		}
}
