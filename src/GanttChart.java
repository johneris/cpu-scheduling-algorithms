import java.util.*;

public class GanttChart {
	
	List<String> _joblist;
	List<String> _timelist;
	
	public GanttChart()	{
		_joblist = new ArrayList<String>();
		_timelist = new ArrayList<String>();
	}
	
	public void addJobList(String _job)	{
		_joblist.add(_job);
	}
	
	public void addTimeList(double _time)	{
		_timelist.add("" + _time);
	}
	
	public List<String> getJobList()	{
		return _joblist;
	}
	
	public List<String> getTimeList()	{
		return _timelist;
	}
	
}
