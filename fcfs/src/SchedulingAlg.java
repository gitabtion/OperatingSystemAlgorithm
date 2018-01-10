import java.util.LinkedList;
import java.util.Queue;

/**
 * @author abtion
 * @since 2018/1/10 23:37
 * email abtion@outlook.com
 * FCFS调度算法
 */
public class SchedulingAlg {
    private Queue<ProcessModel> readyList;  //就绪队列
    private Queue<ProcessModel> doneList;   //完成队列
    private int timeSlice;  //时间片大小

    public SchedulingAlg(Queue<ProcessModel> readyList, int timeSlice) {
        this.readyList = readyList;
        this.timeSlice = timeSlice;
        this.doneList = new LinkedList<>();
    }

    /**
     * 按时间片轮转逐个运行就绪队列中的进程
     * 至就绪队列为空结束
     */
    public void runProcess() {
        int turnarroundTime = 0;
        while (readyList.size() != 0) {
            int processNum = readyList.size();
            for (int i = 0; i < processNum; i++) {
                //队首进程出队
                ProcessModel runnningProcess = readyList.poll();
                //此次执行不会导致进程结束
                if (runnningProcess.getServedTime() + timeSlice < runnningProcess.getNeededTime()) {
                    turnarroundTime += timeSlice;
                    runnningProcess.setServedTime(runnningProcess.getServedTime() + timeSlice);
                    // 进程入队尾
                    readyList.offer(runnningProcess);
                    System.out.println("执行：" + runnningProcess.getPid());
                    System.out.println("到达时间：" + runnningProcess.getArriveTime());
                    System.out.println("已执行时间：" + runnningProcess.getServedTime());
                    System.out.println("总需执行时间：" + runnningProcess.getNeededTime());
                    System.out.println();
                } else {
                    turnarroundTime += (runnningProcess.getNeededTime() - runnningProcess.getServedTime());
                    runnningProcess.setServedTime(runnningProcess.getNeededTime());
                    runnningProcess.setTurnarroundTime(turnarroundTime);
                    System.out.println("执行：" + runnningProcess.getPid());
                    System.out.println("到达时间：" + runnningProcess.getArriveTime());
                    System.out.println("已执行时间：" + runnningProcess.getServedTime());
                    System.out.println("总需执行时间：" + runnningProcess.getNeededTime());
                    System.out.println("该进程执行完成\n");
                    // 进程入结束队列队尾
                    doneList.offer(runnningProcess);
                }
            }
        }
        printInfo();
    }

    /**
     * 打印完成后的相关信息
     */
    private void printInfo() {
        System.out.println("就绪队列中所有进程已执行完毕，据执行完成顺序如下");
        for (ProcessModel i : doneList) {
            System.out.println("PID\t" + i.getPid() +
                    "\t到达时间\t" + i.getArriveTime() +
                    "\t服务时间\t" + i.getNeededTime() +
                    "\t周转时间\t" + i.getTurnarroundTime() +
                    "\t带权周转时间\t" + (float) i.getTurnarroundTime() / (float) i.getNeededTime()
            );
        }
    }
}
