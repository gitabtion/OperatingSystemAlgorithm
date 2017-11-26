public class PcbModel implements Comparable<PcbModel>{
	public static final int READY = 0;

	public static final int START = 1;

	public static final int BLOCK = 2;
	
	public static final int FINSHED = 3;

	private int id;

	private int priority;

	private int cpuTime;

	private int allTime;

	private int startBlock;

	private int blockTime;

	private int state;
	
	private int times;

	public PcbModel(int id, int priority, int cpuTime, int allTime,
			int startBlock, int blockTime, int state) {
		this.id = id;
		this.priority = priority;
		this.cpuTime = cpuTime;
		this.allTime = allTime;
		this.startBlock = startBlock;
		this.blockTime = blockTime;
		this.state = state;
		this.times = 0;
	}

	public int getAllTime() {
		return allTime;
	}

	public void setAllTime(int allTime) {
		this.allTime = allTime;
	}

	public int getBlockTime() {
		return blockTime;
	}

	public void setBlockTime(int blockTime) {
		this.blockTime = blockTime;
	}

	public int getCpuTime() {
		return cpuTime;
	}

	public void setCpuTime(int cpuTime) {
		this.cpuTime = cpuTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getStartBlock() {
		return startBlock;
	}

	public void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public void runProg(){
		this.times++;
	}
	public int getTimes(){
		return this.times;
	}

	public int compareTo(PcbModel arg0) {
		if(this.priority>arg0.priority){
			return -1;
		}else if(this.priority<arg0.priority){
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		String str;
		str = id + " " + priority+ " " + cpuTime+ " " + allTime+ " " + startBlock+ " " + blockTime + " ";
		switch(state){
		case READY:
			str += "READY";
			break;
		case START:
			str += "START";
			break;
		case BLOCK:
			str += "BLOCK";
			break;
		default :
			str += "FINSHED";
		}
		return str;
	}

	
}
