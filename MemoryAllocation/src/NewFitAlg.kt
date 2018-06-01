import java.util.*

/**
 * @author abtion.
 * @since 30/10/19 上午9:12.
 * email abtion@outlook.com
 */

fun newFirstFitAlg(mMemory: IntArray, needSize: Int, tagProc: Int, freeMemoryList: MutableList<MemoryModel>) {
    Collections.sort(freeMemoryList, { o1, o2 -> o1.index - o2.index })

    for (i in 0 until freeMemoryList.size) {
        if (freeMemoryList[i].size >= needSize) {

            for (j in freeMemoryList[i].index until freeMemoryList[i].index + needSize) {
                mMemory[j] = tagProc
            }
            freeMemoryList[i].index += needSize
            freeMemoryList[i].size -= needSize
            if (freeMemoryList[i].size <= 0) {
                freeMemoryList.removeAt(i)
            }
            break
        }
        if (i == freeMemoryList.size - 1 && freeMemoryList[i].size < needSize) {
            println("Out of memory")
        }

    }

    println("作业 $tagProc 申请 $needSize k")
    printMem(mMemory)

}


fun newBestFitAlg(mMemory: IntArray, needSize: Int, tagProc: Int, freeMemoryList: MutableList<MemoryModel>) {


    Collections.sort(freeMemoryList, { o1, o2 -> o1.size - o2.size })
    if (freeMemoryList[freeMemoryList.size - 1].size < needSize) {
        println("Out of memory")
        return
    }
    for (i in 0 until freeMemoryList.size) {
        if (freeMemoryList[i].size >= needSize) {
            for (j in freeMemoryList[i].index until freeMemoryList[i].index + needSize) {
                mMemory[j] = tagProc
            }

            freeMemoryList[i].size -= needSize
            freeMemoryList[i].index += needSize
            if (freeMemoryList[i].size <= 0) {
                freeMemoryList.removeAt(i)
            }
            break
        }

    }

    println("作业 $tagProc 申请 $needSize k")
    printMem(mMemory)

}

fun memoryFree(mMemory: IntArray, tagProc: Int, freeSize: Int, freeMemoryList: MutableList<MemoryModel>) {
    var index = 0
    var temp = freeSize
    var tempIndex: MutableList<Int> = MutableList(0, { -1 })
    for (i in 0 until mMemory.size) {
        if (mMemory[i] == tagProc) {
            if (((i > 0) && mMemory[i] != mMemory[i - 1]) || (i == 0)) {
                index = i
            }
            mMemory[i] = 0
            temp--
        }
        if (temp == 0) {
            break
        }
    }
    for (i in 0 until freeMemoryList.size) {
        if (freeMemoryList[i].index == index) {
            freeMemoryList[i].size -= freeSize
            freeMemoryList[i].index -= freeSize
            if (freeMemoryList[i].size == 0) {
                freeMemoryList.removeAt(i)
            }
            break
        }
        if (i == freeMemoryList.size - 1 && freeMemoryList[freeMemoryList.size - 1].index != 0) {
            freeMemoryList.add(MemoryModel(freeSize, index - freeSize + 1))
        }
    }
    Collections.sort(freeMemoryList, { o1, o2 -> o1.index - o2.index })
    for (i in 1 until freeMemoryList.size) {
        if (freeMemoryList[i - 1].index + freeMemoryList[i - 1].size == freeMemoryList[i].index) {
            freeMemoryList[i].size += freeMemoryList[i - 1].size
            freeMemoryList[i].index -= freeMemoryList[i - 1].size
            tempIndex.add(i - 1)
        }
    }

    for (i in 0 until tempIndex.size) {
        freeMemoryList.removeAt(tempIndex[i])
    }
    println("作业 $tagProc 释放 $freeSize k")
    printMem(mMemory)
}

