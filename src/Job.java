
public class Job	{
	
	private int _job_number;
	private double _arrival;
	private double _burst;
	private double _finish;
	
	private double _priority;
	private double _deadline;

	public Job(int _job_number, double _arrival, double _burst,
			double _priority, double _deadline)	{
		this._job_number = _job_number;
		this._arrival = _arrival;
		this._burst = _burst;
		this._finish = 0.0;
		this._priority = _priority;
		this._deadline = _deadline;
	}
	
	public Job(int _job_number, double _arrival, double _burst,
			double _finish, double _priority, double _deadline)	{
		this._job_number = _job_number;
		this._arrival = _arrival;
		this._burst = _burst;
		this._finish = _finish;
		this._priority = _priority;
		this._deadline = _deadline;
	}
	
	public Job()	{
	
	}
	
	//set
	public void setJobNumber(int n)	{
		_job_number = n;
	}
	public void setArrivalTime(double d)	{
		_arrival = d;
	}
	public void setBurstTime(double d)	{
		_burst = d;
	}
	public void setJobFinish(double d)	{
		_finish = d;
	}
	public void setPriority(double d)	{
		_priority = d;
	}
	public void setDeadline(double d)	{
		_deadline = d;
	}
	
	//get
	public int getJobNumber()	{
		return _job_number;	
	}
	public double getArrivalTime()	{
		return _arrival;
	}
	public double getBurstTime()	{
		return _burst;
	}
	public double getJobFinish()	{
		return _finish;
	}
	public double getPriority()	{
		return _priority;
	}
	public double getDeadline()	{
		return _deadline;
	}
}