import com.sun.jmx.remote.internal.ArrayQueue
import java.util.*

/**
 * @author abtion.
 * @since 17/11/13 上午11:21.
 * email abtion@outlook.com
 */

fun main(args: Array<String>) {
    var testFifoEm: Stack<Int> = Stack()
    var testLruEm: Stack<Int> = Stack()
    var testOptEm: Stack<Int> = Stack()
    var sumFifo = 0.0
    var sumLru = 0.0
    var sumOpt = 0.0
    var testCommand: IntArray = kotlin.IntArray(320, { i -> i })
    var testCommandQueue: ArrayQueue<Int> = ArrayQueue(320)
    println("\t\tFIFO\t\t\tLRU\t\t\t\tOPT")
    var index = 0
    var randomSize = 319
    for (i in 0..79) {
        index += ((Math.random() * randomSize) % randomSize).toInt()
        testCommandQueue.add(testCommand[index])
        testCommandQueue.add(testCommand[index + 1])
        randomSize = index + 1
        index = ((Math.random() * randomSize) % randomSize).toInt()
        testCommandQueue.add(testCommand[index])
        testCommandQueue.add(testCommand[index + 1])
        index += 1
        randomSize = 319 - index
    }

    for (i in 0..319) {
        var tempCommand = testCommandQueue[0]
        print("$i\t")
        print("$tempCommand\t")
        sumFifo += fifo(testFifoEm, tempCommand)
        sumLru += lru(testLruEm, tempCommand)
        sumOpt += opt(testOptEm, testCommandQueue)
        testCommandQueue.removeAt(0)
    }
    println("FIFO:${sumFifo / 320}")
    println("LRU:${sumLru / 320}")
    println("OPT:${sumOpt / 320}")

}