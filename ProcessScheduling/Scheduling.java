import java.util.ArrayList;
import java.util.Collections;

public class Scheduling {
	private ArrayList<PcbModel> readyQueue;
	private ArrayList<PcbModel> blockQueue;
	private ArrayList<PcbModel> finshQueue;
	private ArrayList<PcbModel> tempQueue;
	
	public Scheduling(ArrayList<PcbModel> readyQueue, ArrayList<PcbModel> blockQueue) {
		this.readyQueue = readyQueue;
		this.blockQueue = blockQueue;
		this.finshQueue = new ArrayList();
		this.tempQueue = new ArrayList();
	}
	
	public void runProg(){
		Collections.sort(readyQueue);
		PcbModel running = null;
		if(readyQueue.size()!=0){
			running = readyQueue.get(0);
			running.setState(PcbModel.START);
			System.out.println("Running Prog: "+ running.getId());
		}else {
			System.out.println("Running Prog: ");
		}
		System.out.print("Ready Queue");
		for(PcbModel item : readyQueue){
			if(!item.equals(running)){
				System.out.print(" ->"+item.getId());
			}
			item.setPriority(item.getPriority()+1);
		}
		
		System.out.println();
		System.out.print("Block Queue:");
		for(PcbModel item : blockQueue){
			System.out.print(" ->"+item.getId());
		}
		System.out.println();
		System.out.println("==========================");
		System.out.println("ID PRIORITY CPUTIME ALLTIME STARTBLOCK BLOCKTIME STATE");
		for(PcbModel item : readyQueue){
			System.out.println(item.toString());
			item.setCpuTime(item.getCpuTime()+1);
		}
		for(PcbModel item : blockQueue){
			System.out.println(item.toString());
			item.setCpuTime(item.getCpuTime()+1);
			item.setBlockTime(item.getBlockTime()-1);
			item.setStartBlock(item.getBlockTime()-1);
//			阻塞完毕就绪
			if (item.getBlockTime()==0) {
				tempQueue.add(item);
				item.setState(PcbModel.READY);
				readyQueue.add(item);
			}
		}
		for(PcbModel item : tempQueue){
			blockQueue.remove(item);
		}
		tempQueue.clear();
		for(PcbModel item : finshQueue){
			System.out.println(item.toString());
			item.setCpuTime(item.getCpuTime()+1);
		}
		
		System.out.println();
		
		
		if(running!=null){
//			运行，改变pcb的参数
			running.setPriority(running.getPriority()-4);
			running.setAllTime(running.getAllTime()-1);
			running.runProg();
			running.setState(PcbModel.READY);
			if(running.getAllTime()== 0){
				readyQueue.remove(running);
				running.setState(PcbModel.FINSHED);
				finshQueue.add(running);
			}
			
			//到时间阻塞
			if (running.getStartBlock()==running.getTimes()) {
				readyQueue.remove(running);
				running.setState(PcbModel.BLOCK);
				blockQueue.add(running);
			}
		}
		
		
		
		if(readyQueue.size()!=0||blockQueue.size()!=0){
			this.runProg();
		}else {
			System.out.println("=============END=============");
			System.out.println("ID PRIORITY CPUTIME ALLTIME STARTBLOCK BLOCKTIME STATE");
			for(PcbModel item : finshQueue){
				System.out.println(item.toString());
			}
		}
	}
	

}
