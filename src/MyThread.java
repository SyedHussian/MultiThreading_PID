
import java.sql.Time;

public class MyThread implements Runnable{


	private final int MIN_PID = 300;
	private final int MAX_PID = 5000;
	
	private int[] pid;

	public void run(){
		try {
			allocat_PID();
		}catch (Exception e) {}
	}
	
	public int allocat_Map() {
		pid = new int[MAX_PID - MIN_PID];
		
		if (pid == null){
			System.out.println("Memory allocation failed.");
			return 1;
		}
		 
		for (int i = 0; i < pid.length; i++){
			pid[i] = 0;
		}
		 
		System.out.println("Memory allocated successfully.");
		return 1;
	}
	
	public int allocat_PID(){
		SleepUtilities sl = new SleepUtilities();
		if (pid == null){
			System.out.println("PID Manager is not initialized ");
			return 1;
		}
		  
		int pidNum = 1;
		  
		for (int i = 0; i < pid.length; i++){
			if (pid[i] == 0){
				pid[i] = 1;
				pidNum = i + MIN_PID;
				System.out.println("My PID: " + pidNum);
				sl.nap(60);
				release_PID(pidNum);
				break;
			}
		}
		if (pidNum == 1){
			System.out.println("Unable to allocat PID");
			return 1;
		}
//		System.out.println("Allocate PID :" + pidNum);
		return pidNum;
	}
	
	public void release_PID(int pidNum){
		if (pid == null){
			System.out.println("PID Manager is not initialized ");
			return;
		}
		if (pidNum < MIN_PID || pidNum > MAX_PID){
			System.out.println("Given PID is out or Range");
		}
		int newPid = pidNum - MIN_PID;
		if (pid[newPid] == 0){
			System.out.println("PID " + pidNum + " is already released ");
			return;
		}
	  
		System.out.println("Releasing PID :" + pidNum);  
	  	pid[newPid] = 0;
	}	
}


