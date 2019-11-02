
public class Main{
	public static void main(String[] args){
		int numOfThread = 100;
		MyThread mt = new MyThread();
		mt.allocat_Map();
		
		for (int i =0; i<numOfThread; i++) {
			Thread t1 = new Thread(mt);
			t1.start();
			
			try {
				if(t1.isAlive()) {
					continue;
				}
				else {
					t1.join();
				}
			}catch (Exception e) {}
		}

	}
}
