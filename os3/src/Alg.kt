
import com.sun.jmx.remote.internal.ArrayQueue
import java.util.*

/**
 * @author abtion.
 * @since 17/11/13 上午10:58.
 * email abtion@outlook.com
 */

private val MAX_MEMORY_SIZE = 4

fun lru(em: Stack<Int>, command: Int): Int {
    var result = 1
    when {
        em.contains(command / 10) -> {
            (0 until em.size)
                    .filter { em[it] == command / 10 }
                    .forEach { print("命中:${it * 10 + command % 10} \t\t\t") }
            result = 0
            em.remove(command / 10)
            em.push(command / 10)
        }
        em.size < MAX_MEMORY_SIZE -> {
            em.push(command / 10)
            print("缺页\t\t\t\t")
        }
        else -> {
            print("替换:${em[0]} -> ${command / 10 }  \t")
            em.remove(em[0])
            em.push(command / 10)
        }
    }
    return result
}

fun fifo(em: Stack<Int>, command: Int): Int {
    var result = 1
    when {
        em.contains(command / 10) -> {
            (0 until em.size)
                    .filter { em[it] == command / 10 }
                    .forEach { print("命中:${it * 10 + command % 10} \t\t\t") }
            result = 0
        }
        em.size < MAX_MEMORY_SIZE -> {
            em.push(command / 10)
            print("缺页 \t\t\t")
        }
        else -> {
            print("替换:${em[0]} -> ${command / 10}  \t")
            em.remove(em[0])
            em.push(command / 10)
        }
    }
    return result
}

fun opt(em: Stack<Int>, commandQueue: ArrayQueue<Int>):Int {
    var result =1
    var command = commandQueue[0]
    if (em.contains(command / 10)) {
        (0 until em.size)
                .filter { em[it] == command / 10 }
                .forEach { println("命中:${it * 10 + command % 10}") }
        result = 0

    } else if (em.size < MAX_MEMORY_SIZE) {
        em.push(command / 10)
        println("缺页")
    } else {
        var tempStack: Stack<Int> = Stack()
        for (i in 0 until commandQueue.size) {
            if (tempStack.size >= 3) {
                break
            } else {
                if (!tempStack.contains(commandQueue[i] / 10)&&em.contains(commandQueue[i]/10)) {
                    tempStack.push(commandQueue[i] / 10)
                }
            }
        }
        if (tempStack.size <= 4) {
            for(i in 0 until em.size){
                if (!tempStack.contains(em[i])){
                    println("替换:${em[i]} -> ${command / 10}")
                    em.remove(em[i])
                    em.push(command/10)
                    break
                }
            }
        }
    }
    return result
}