
import entity.WorkLog;

import javax.swing.JOptionPane;
import java.util.Calendar;

import java.awt.Color;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

class MainPanel extends JFrame
{
	public MainPanel() {

		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Input Dialog in Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setSize(400, 300);
		getContentPane().setLayout(null);

	}

	private void closeIt(){

		this.getContentPane().setVisible(false);
		this.dispose();

	}

	public static void main(String[] args)
	{
		if (args.length == 0 || Integer.parseInt(args[0]) <= Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
			System.out.println("Usage: java MainPanel <Finish hour 24h format>");
			System.err.println("The end hour is required");
			System.err.println("The finish hour should be greater than current hour.");
			System.exit(1);
		}
		do {
		    WorkLog wlog = new WorkLog();

			int minutesToWait = (args.length == 2)? Integer.parseInt(args[1]): 30;
			try {
				TimeUnit.MINUTES.sleep(minutesToWait);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			MainPanel frame = new MainPanel();
			frame.setAlwaysOnTop(true);
			String task = JOptionPane.showInputDialog(frame, "Enter the Task code:");

			wlog.setTask(task);

			if(task.contains(":")) {
				wlog.setTask(task.split(":")[0]);
				wlog.setDescription(task.split(":")[1]);
			}

			int counter = 3;

			System.out.printf("You have spent %d minutes on %s \n",
			wlog.getDuration(),
			wlog.getTask());
			wlog.setFinishedAt(new Date());
			Storage storage = new Storage(wlog);
			storage.save();
			frame.closeIt();
		} while ( Integer.parseInt(args[0]) > Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
	}
	
}