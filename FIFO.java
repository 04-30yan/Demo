package test;

import java.util.LinkedList;

public class FIFO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pages = {2,1,2,3,1};
		int cache = 2;
		System.out.println(pageReplacement(pages, cache));
	}
	public static int pageReplacement(int[] pages, int cache) {
		LinkedList<Integer> queue = new LinkedList<>();
		int fault = 0;
		for(int i = 0; i < pages.length; i++) {
			if(queue.contains(pages[i])) {
				continue;
			}
			if(queue.size() >= 2) {
				queue.pollFirst();	
			}
			queue.add(pages[i]);
			fault++;
		}
		return fault;
	}

}
