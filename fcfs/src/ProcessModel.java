/**
 * @author abtion
 * @since 2018/1/10 23:52
 * email abtion@outlook.com
 * 进程的抽象模型
 */
public class ProcessModel {
    private int pid;
    private int arriveTime; //到达时间
    private int neededTime; //总所需时间
    private int servedTime; //已服务时间
    private int turnarroundTime;    //周转时间

    public ProcessModel(int pid, int arriveTime, int neededTime) {
        this.pid = pid;
        this.arriveTime = arriveTime;
        this.neededTime = neededTime;
        this.servedTime = 0;
        this.turnarroundTime = 0;
    }

    public int getPid() {
        return pid;
    }

    public int getArriveTime() {
        return arriveTime;
    }


    public int getNeededTime() {
        return neededTime;
    }


    public int getServedTime() {
        return servedTime;
    }

    public void setServedTime(int servedTime) {
        this.servedTime = servedTime;
    }

    public int getTurnarroundTime() {
        return turnarroundTime;
    }

    public void setTurnarroundTime(int turnarroundTime) {
        this.turnarroundTime = turnarroundTime;
    }
}
