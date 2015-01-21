import java.util.*;

public class PriorityQueue	{
	List<Job> _queue;
	Algorithm _algorithm;
	
	public PriorityQueue(Algorithm algo)	{
		_queue = new ArrayList<Job>();
		_algorithm = algo;
	}
	
	public void enqueue(Job job)	{
		boolean done = false;
		for(int i=0; i<_queue.size(); i++)	{
			if( job == _queue.get(i) )
				done = true;
		}
		if(done==false)	{
			_queue.add(job);
			sort();
		}
	}
	
	public Job dequeue()	{
		Job temp = new Job();
		temp = _queue.get(0);
		_queue.remove(0);
		return temp;
	}
	
	public boolean isEmpty()	{
		return _queue.isEmpty(); 
	}
	
	public void printQueue()	{
		for( Job job : _queue )
			System.out.println("Job"+job.getJobNumber());
	}
	
	public void sort()	{
		int i=0, j=0; 
		if( _algorithm == Algorithm.FCFS || _algorithm == Algorithm.RR)	{
			Job temp = new Job();
			for(i=1; i<_queue.size(); i++)	{
				temp = _queue.get(i);
				j = i;
				while( (j>0) && (_queue.get(j-1).getArrivalTime() > temp.getArrivalTime()) )	{
					_queue.remove(j);
					_queue.add(j, _queue.get(j-1));
					j -= 1;
				}
				_queue.remove(j);
				_queue.add(j, temp);
			}
		}
		else if( _algorithm == Algorithm.SJF || _algorithm == Algorithm.SRTF )	{
			Job temp = new Job();
			for(i=1; i<_queue.size(); i++)	{
				temp = _queue.get(i);
				j = i;
				while( (j>0) && (_queue.get(j-1).getBurstTime() > temp.getBurstTime()) )	{
					_queue.remove(j);
					_queue.add(j, _queue.get(j-1));
					j -= 1;
				}
				_queue.remove(j);
				_queue.add(j, temp);
			}
		}
		else if( _algorithm == Algorithm.Prio || _algorithm == Algorithm.PPrio )	{
			Job temp = new Job();
			for(i=1; i<_queue.size(); i++)	{
				temp = _queue.get(i);
				j = i;
				while( (j>0) && (_queue.get(j-1).getPriority() > temp.getPriority()) )	{
					_queue.remove(j);
					_queue.add(j, _queue.get(j-1));
					j -= 1;
				}
				_queue.remove(j);
				_queue.add(j, temp);
			}
		}
		else if( _algorithm == Algorithm.Deadline )	{
			Job temp = new Job();
			for(i=1; i<_queue.size(); i++)	{
				temp = _queue.get(i);
				j = i;
				while( (j>0) && (_queue.get(j-1).getDeadline() > temp.getDeadline()) )	{
					_queue.remove(j);
					_queue.add(j, _queue.get(j-1));
					j -= 1;
				}
				_queue.remove(j);
				_queue.add(j, temp);
			}
		}
	}	
	
}