import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author abtion
 * @since 2018/1/11 00:43
 * email abtion@outlook.com
 * 测试类
 */
public class test {
    public static void main(String[] args) {
        int processNum, timeSlice;
        Queue<ProcessModel> readyList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入欲执行进程数量");
        processNum = scanner.nextInt();
        System.out.println("请输入每个时间片单位时间");
        timeSlice = scanner.nextInt();

        //不妨设PID递增，到达时间间隔为10，总需服务时间为100以内的随机正整数
        for (int i = 0; i < processNum; i++) {
            readyList.offer(new ProcessModel(i, i * 10, (int) (Math.random() * 100)));
        }
        SchedulingAlg sa = new SchedulingAlg(readyList, timeSlice);
        sa.runProcess();
    }
}
