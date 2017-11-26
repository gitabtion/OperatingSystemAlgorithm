# OperatingSystemAlgorithm
Common operating system algorithms

## 1.动态优先权算法的模拟
- 使用Java
- 通过对pcb的信息更改模拟进程的调度
- 每个用来标识进程的进程控制块 PCB 用结构来 述，包括以下字段:
	- 进程标识数 ID。
	- 进程优先数 PRIORITY，并规定优先数越大的进程，其优先权越高。
	- 进程已占用的 CPU 时间 CPUTIME。
	- 进程还需占用的 CPU 时间 ALLTIME。当进程运行完毕时，ALLTIME 变为 0。
	- 进程的阻塞时间 STARTBLOCK，表示当进程再运行 STARTBLOCK 个时间片后，将进入阻塞状态。
	- 进程被阻塞的时间 BLOCKTIME，表示已阻塞的进程再等待 BLOCKTIME 个时间片后，将转换成就绪状态。 
	- 进程状态 STATE。
队列指针 NEXT，用来将 PCB 排成队列。
- 优先数改变的原则:
	- 进程在就绪队列中停留一个时间片，优先数加 1。
	-  进程每运行一个时间片，优先数减 3。
- 设初始进程及状态如下

|ID|PRIORITY|CPUTIME|ALLTIME|STARTBLOCK|BLOCKTIME|STATE|
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|0|9|0|3|2|3|READY|
|1|38|0|3|-1|0|READY|
|2|30|0|6|-1|0|READY|
|3|29|0|3|-1|0|READY|
|4|0|0|4|-1|0|READY|