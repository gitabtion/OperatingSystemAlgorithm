/**
 * @author abtion.
 * @since 17/10/19 上午1:12.
 * email abtion@outlook.com
 */

fun firstFitAlg(mMemory: IntArray, needSize: Int, tagProc: Int){

    //0为未占用
    var startPoint = 0
    var tempMem = 0

    for (i in 0 until mMemory.size) {
        if (tempMem == needSize) break
        if (mMemory.get(i) == 0) {
            if (tempMem == 0) startPoint = i
            tempMem++
        } else {
            if (tempMem < needSize) tempMem = 0
        }
    }

    if (tempMem != 0) {
        for (i in startPoint until (tempMem + startPoint)) {
            mMemory[i] = tagProc
        }
    }
    println("作业 " + tagProc + " 申请 " + needSize + " k")
    printMem(mMemory)

}

fun worstFitAlg(mMemory: IntArray, needSize: Int, tagProc: Int) {

    var biggestFreeMemoryIndex = 0
    var biggestFreeMemorySize = 0
    var tempMemoryIndex = 0

    for (i in 1 until mMemory.size) {
        if (mMemory[i - 1] != mMemory[i]) {
            if (mMemory[i - 1] == 0 && (i - tempMemoryIndex > biggestFreeMemoryIndex)) {
                biggestFreeMemoryIndex = tempMemoryIndex
                biggestFreeMemorySize = i - tempMemoryIndex
            } else if (mMemory[i] == 0) {
                tempMemoryIndex = i
            }
        }
        if (i == mMemory.size - 1 && mMemory[i] == 0 && i - tempMemoryIndex >= biggestFreeMemorySize) {
            biggestFreeMemorySize = i - tempMemoryIndex + 1
            biggestFreeMemoryIndex = tempMemoryIndex
        }
    }

    if (needSize > biggestFreeMemorySize) {
        print("overFlow")
    } else {
        for (i in biggestFreeMemoryIndex until biggestFreeMemoryIndex + needSize) {
            mMemory[i] = tagProc
        }
    }
    println("作业 " + tagProc + " 申请 " + needSize + " k")
    printMem(mMemory)
}

fun bestFitAlg(mMemory: IntArray, needSize: Int, tagProc: Int) {


    var bestFreeMemoryIndex = 0
    var bestFreeMemorySize = mMemory.size
    var tempMemoryIndex = 0

    for (i in 1 until mMemory.size) {
        if (mMemory[i - 1] != mMemory[i]) {
            var tempSize = i-tempMemoryIndex
            if (mMemory[i - 1] == 0 && (tempSize < bestFreeMemorySize)&&tempSize>=needSize) {
                bestFreeMemoryIndex = tempMemoryIndex
                bestFreeMemorySize = i - tempMemoryIndex
            } else if (mMemory[i] == 0) {
                tempMemoryIndex = i
            }
        }
        var tempSize = i-tempMemoryIndex
        if (i == mMemory.size - 1 && mMemory[i] == 0 && i - tempMemoryIndex+1 < bestFreeMemorySize&&tempSize>needSize) {
            bestFreeMemorySize = i - tempMemoryIndex + 1
            bestFreeMemoryIndex = tempMemoryIndex
        }
    }

    if (needSize > bestFreeMemorySize) {
        println("overFlow")
    } else {
        for (i in bestFreeMemoryIndex until bestFreeMemoryIndex + needSize) {
            mMemory[i] = tagProc
        }
    }
    println("作业 " + tagProc + " 申请 " + needSize + " k")
    printMem(mMemory)

}

fun printMem(mMemory: IntArray) {
    println("==============================================")
    print(mMemory.get(0).toString() + ": 0")
    for (i in 1 until mMemory.size) {
        if (mMemory.get(i) != mMemory.get(i - 1)) {
            println(" ~ " + (i - 1))
            print(mMemory.get(i).toString() + ": " + i)
        }
    }
    println(" ~ " + (mMemory.size - 1))
    println()
}

fun memoryFree(mMemory: IntArray, tagProc: Int, freeSize: Int){
    var temp = freeSize
    for (i in 0 until mMemory.size) {
        if (mMemory[i] == tagProc) {
            mMemory[i] = 0
            temp--
        }
        if (temp == 0) {
            break
        }
    }
    println("作业 " + tagProc + " 释放 " + freeSize + " k")
    printMem(mMemory)
}

fun initMemory(mMemory: IntArray) {
    println("清理所有内存")
    for (i in 0 until mMemory.size) {
        mMemory[i] = 0
    }
    printMem(mMemory)
}