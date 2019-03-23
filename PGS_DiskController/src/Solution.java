import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

	public int solution(int[][] jobs) {
        int answer = 0;
        
        ArrayList<Job> list = new ArrayList<Job>();
        PriorityQueue<Job> pri_queue = new PriorityQueue<Job>(
        		(Job o1, Job o2) -> o1.process - o2.process);
        
        for (int i = 0; i < jobs.length; i++)
        	list.add(new Job(jobs[i][0], jobs[i][1]));
        
        list.sort((Job o1, Job o2) -> o1.request - o2.request);
        
        int idx = 0, end = 0;
        while (idx < jobs.length) {
        	end = list.get(idx).request;
        	
        	while(true) {
        		while (idx < jobs.length && end >= list.get(idx).request) {
            		pri_queue.offer(new Job(list.get(idx).request, list.get(idx).process));
            		idx++;
            	}
        		
        		if (!pri_queue.isEmpty()) {
        			Job job = pri_queue.poll();
        			answer += (job.process + (end - job.request));
        			end += job.process;
        		}
        		else break;
        	}
        }
        return answer /= jobs.length;
    }
}

class Job {
	int request, process;
	public Job(int request, int process) {
		this.request = request; this.process = process;
	}
}