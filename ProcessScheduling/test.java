import java.util.ArrayList;


public class test {
	public static void main(String[] args){
		ArrayList<PcbModel> readyQueue = new ArrayList();
		ArrayList<PcbModel> blockQueue = new ArrayList();
		readyQueue.add(new PcbModel(0,9,0,3,2,3,0));
		readyQueue.add(new PcbModel(1,38,0,3,-1,0,0));
		readyQueue.add(new PcbModel(2,30,0,6,-1,0,0));
		readyQueue.add(new PcbModel(3,29,0,3,-1,0,0));
		readyQueue.add(new PcbModel(4,0,0,4,-1,0,0));
		
		Scheduling scheduling = new Scheduling(readyQueue,blockQueue);
		scheduling.runProg();
	}
}
