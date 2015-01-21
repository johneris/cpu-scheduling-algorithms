import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class FrameMain 
	extends JFrame
	implements ActionListener, ItemListener	{
	
	private static final long serialVersionUID = 1L;
	
	List<Job> _jobs;
	Algorithm _algorithm;
	
	JPanel _panel_gantt;
	JScrollPane _scrollpane;
	Font _font_job;
	
	JLabel _lbl_jobno;
	JComboBox<String> _combo_jobs;
	
	JLabel _lbl_arrival;
	JTextField _txt_arrival;
	
	JLabel _lbl_burst;
	JTextField _txt_burst;
	
	JLabel _lbl_deadline;
	JTextField _txt_deadline;
	
	JLabel _lbl_priority;
	JTextField _txt_priority;
	
	CheckboxGroup _cbg_algo;
	Checkbox _cb_FCFS;
	Checkbox _cb_SJF;
	Checkbox _cb_PRIO;
	Checkbox _cb_DEADLINE;
	Checkbox _cb_PPRIO;
	Checkbox _cb_SRTF;
	Checkbox _cb_RR;
	
	JButton _btn_add;
	JButton _btn_save;
	JButton _btn_delete;

	JButton _btn_run;
	
	TextArea _txt_result_tt;
	TextArea _txt_result_wt;
	
	public FrameMain()	{
		_jobs = new ArrayList<Job>();
		_algorithm = Algorithm.FCFS;
		initUI();
	}
	
	void initUI()	{
		
		_panel_gantt = new JPanel();
		
		_scrollpane = new JScrollPane(_panel_gantt);
		_scrollpane.setBounds(20, 20, 540, 100);	
		_font_job = new Font("Times New Roman", Font.PLAIN, 16);
		
		_lbl_jobno = new JLabel("Job Number: ");
		_lbl_jobno.setBounds(20, 130, 100, 20);
		_combo_jobs = new JComboBox<String>();
		_combo_jobs.setBounds(100, 130, 130, 20);
		_combo_jobs.addItemListener(this);
		
		_lbl_arrival = new JLabel("Arrival Time: ");
		_lbl_arrival.setBounds(20, 160, 100, 20);
		_txt_arrival = new JTextField();
		_txt_arrival.setBounds(100, 160, 50, 20);
		
		_lbl_burst = new JLabel("Burst Time: ");
		_lbl_burst.setBounds(20, 185, 100, 20);
		_txt_burst = new JTextField();
		_txt_burst.setBounds(100, 185, 50, 20);
		
		_lbl_deadline = new JLabel("Deadline: ");
		_lbl_deadline.setBounds(190, 160, 100, 20);
		_txt_deadline = new JTextField();
		_txt_deadline.setBounds(250, 160, 50, 20);
		
		_lbl_priority = new JLabel("Priority: ");
		_lbl_priority.setBounds(190, 185, 100, 20);
		_txt_priority = new JTextField();
		_txt_priority.setBounds(250, 185, 50, 20);
		
		_cbg_algo = new CheckboxGroup();
		
		_cb_FCFS = new Checkbox("First Come First Serve (FCFS)", true, _cbg_algo);
		_cb_FCFS.setBounds(325, 130, 200, 20);
		_cb_FCFS.addItemListener(this);
		
		_cb_SJF = new Checkbox("Shortest Job First (SJF)", false, _cbg_algo);
		_cb_SJF.setBounds(325, 155, 200, 20);
		_cb_SJF.addItemListener(this);
		
		_cb_PRIO = new Checkbox("Priority (Prio)", false, _cbg_algo);
		_cb_PRIO.setBounds(325, 180, 200, 20);
		_cb_PRIO.addItemListener(this);
		
		_cb_DEADLINE = new Checkbox("Deadline", false, _cbg_algo);
		_cb_DEADLINE.setBounds(325, 205, 200, 20);
		_cb_DEADLINE.addItemListener(this);
		
		_cb_PPRIO = new Checkbox("Preemptive Priority (P-Prio)", false, _cbg_algo);
		_cb_PPRIO.setBounds(325, 230, 200, 20);
		_cb_PPRIO.addItemListener(this);
		
		_cb_SRTF = new Checkbox("Shortest Remaining Time First (SRTF)", false, _cbg_algo);
		_cb_SRTF.setBounds(325, 255, 250, 20);
		_cb_SRTF.addItemListener(this);
		
		_cb_RR = new Checkbox("Round Robin (RR)", false, _cbg_algo);
		_cb_RR.setBounds(325, 280, 200, 20);
		_cb_RR.addItemListener(this);
		
		_btn_add = new JButton("Add");
		_btn_add.setBounds(50, 220, 60, 24);
		_btn_add.addActionListener(this);
		
		_btn_save = new JButton("Save");
		_btn_save.setBounds(130, 220, 65, 24);
		_btn_save.addActionListener(this);
		
		_btn_delete = new JButton("Delete");
		_btn_delete.setBounds(210, 220, 70, 24);
		_btn_delete.addActionListener(this);
		
		_btn_run = new JButton("Run");
		_btn_run.setBounds(140, 270, 60, 24);
		_btn_run.addActionListener(this);
		
		_txt_result_tt = new TextArea("", 540, 120, TextArea.SCROLLBARS_VERTICAL_ONLY);
		_txt_result_tt.setBounds(20, 320, 260, 120);
		_txt_result_tt.setEditable(false);
		
		_txt_result_wt = new TextArea("", 540, 120, TextArea.SCROLLBARS_VERTICAL_ONLY);
		_txt_result_wt.setBounds(300, 320, 260, 120);
		_txt_result_wt.setEditable(false);
		
		this.setLayout(null);
		
		this.add(_scrollpane);
		
		this.add(_lbl_jobno);
		this.add(_combo_jobs);
		
		this.add(_lbl_arrival);
		this.add(_txt_arrival);
		
		this.add(_lbl_burst);
		this.add(_txt_burst);
		
		this.add(_lbl_deadline);
		this.add(_txt_deadline);
		
		this.add(_lbl_priority);
		this.add(_txt_priority);
		
		this.add(_cb_FCFS);
		this.add(_cb_SJF);
		this.add(_cb_PRIO);
		this.add(_cb_DEADLINE);
		this.add(_cb_PPRIO);
		this.add(_cb_SRTF);
		this.add(_cb_RR);
		
		this.add(_btn_add);
		this.add(_btn_save);
		this.add(_btn_delete);
		
		this.add(_btn_run);
		
		this.add(_txt_result_tt);
		this.add(_txt_result_wt);
		
		this.setSize(600, 500);
		this.setTitle("CPU Scheduling Algorithms");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	void refreshList()	{
		_combo_jobs.removeAllItems();
		for(int i = 1; i <= _jobs.size(); i++)	{
			_combo_jobs.addItem("Job # " + i);
		}
	}
	
	void refreshDetails()	{
		if(_jobs.isEmpty())	{
			_txt_arrival.setText("");
			_txt_burst.setText("");
			_txt_priority.setText("");
			_txt_deadline.setText("");
			return;
		}
		int index = _combo_jobs.getSelectedIndex();
		if(index < 0)	return;
		_txt_arrival.setText("" + _jobs.get(index).getArrivalTime());
		_txt_burst.setText("" + _jobs.get(index).getBurstTime());
		_txt_priority.setText("" + _jobs.get(index).getPriority());
		if(_jobs.get(index).getDeadline() == Double.POSITIVE_INFINITY)
			_txt_deadline.setText("none");
		else 
			_txt_deadline.setText("" + _jobs.get(index).getDeadline());
	}
	
	void drawGanttChart(GanttChart _gantt_chart)	{
		_panel_gantt.removeAll();
		_panel_gantt.repaint();
		_panel_gantt.validate();
		JTextArea _txt = new JTextArea(3, 7);
		_txt.setEditable(false);
		_txt.setText("\n\n\n           0.0");
		_txt.setFont(_font_job);
		_txt.setBackground(getBackground());
		_panel_gantt.add(_txt);
		_panel_gantt.validate();
		for(int i = 0; i < _gantt_chart.getJobList().size(); i++)	{
			JTextArea txt = new JTextArea(3, 7);
			txt.setEditable(false);
			txt.setText(_gantt_chart.getJobList().get(i) + "\n\n           " 
					+ _gantt_chart.getTimeList().get(i));
			txt.setFont(_font_job);
			txt.setBackground(getBackground());
			_panel_gantt.add(txt);
			_panel_gantt.validate();
		}
		refreshList();
	}
	
	public void actionPerformed(ActionEvent e)	{
		if(e.getSource() == _btn_add)	{
			_jobs.add( 
					new Job(_jobs.size()+1, 0, 0, 
							_jobs.size()+1, Double.POSITIVE_INFINITY)
				);
			refreshList();
			_combo_jobs.setSelectedIndex(_jobs.size()-1);
		}
		if(e.getSource() == _btn_save)	{
			if(_jobs.isEmpty())	return;
			int index = _combo_jobs.getSelectedIndex();
			try {
				_jobs.get(index).setArrivalTime(
						Double.parseDouble(_txt_arrival.getText())
					);
			}catch(Exception ex)	{		
			}
			try {
				_jobs.get(index).setBurstTime(
						Double.parseDouble(_txt_burst.getText())
					);
			}catch(Exception ex)	{		
			}
			try {
				if(_txt_deadline.getText().equalsIgnoreCase("none"))
					_jobs.get(index).setDeadline(Double.POSITIVE_INFINITY);
				else
					_jobs.get(index).setDeadline(
							Double.parseDouble(_txt_deadline.getText())
						);
			}catch(Exception ex)	{		
			}
			try {
				_jobs.get(index).setPriority(
						Double.parseDouble(_txt_priority.getText())
					);
			}catch(Exception ex)	{		
			}
			refreshDetails();
			JOptionPane.showMessageDialog(null, "Job # " + (index+1) +" Saved", 
					"Save", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource() == _btn_delete)	{
			if(_jobs.isEmpty())	return;
			int index = _combo_jobs.getSelectedIndex();
			_jobs.remove(index);
			refreshList();
			JOptionPane.showMessageDialog(null, "Job " + (index+1) +" Deleted", 
					"Delete", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource() == _btn_run)	{
			if(_jobs.isEmpty())	{
				_txt_result_tt.setText("");
				_txt_result_wt.setText("");
				return;
			}
			for(int i = 1; i <= _jobs.size(); i++)
				_jobs.get(i-1).setJobNumber(i);
			CPU_Scheduling _solver = new CPU_Scheduling(_jobs, _algorithm);
			if( _solver.solve() )	{
				_txt_result_tt.setText(_solver.getResultTT());
				_txt_result_wt.setText(_solver.getResultWT());
				drawGanttChart(_solver.getGanttChart());
			}
		}
	}
	
	public void itemStateChanged(ItemEvent e)	{
		if(_cb_FCFS.getState())	{
			_algorithm = Algorithm.FCFS;
		}
		if(_cb_SJF.getState())	{
			_algorithm = Algorithm.SJF;
		}
		if(_cb_PRIO.getState())	{
			_algorithm = Algorithm.Prio;
		}
		if(_cb_DEADLINE.getState())	{
			_algorithm = Algorithm.Deadline;
		}
		if(_cb_PPRIO.getState())	{
			_algorithm = Algorithm.PPrio;
		}
		if(_cb_SRTF.getState())	{
			_algorithm = Algorithm.SRTF;
		}
		if(_cb_RR.getState())	{
			_algorithm = Algorithm.RR;
		}
		
		refreshDetails();
	}

	public static void main(String[] args) {
		new FrameMain();
	}

}
