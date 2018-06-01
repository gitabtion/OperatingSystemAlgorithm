import java.util.*

/**
 * @author abtion.
 * @since 17/10/19 上午1:38.
 * email abtion@outlook.com
 */

fun main(args: Array<String>) {
    var memoryArray: IntArray = kotlin.IntArray(640, { i -> 0 })
    println("\nFist Fit\n")
    printMem(memoryArray)
    firstFitAlg(memoryArray, 130, 1)
    firstFitAlg(memoryArray, 60, 2)
    firstFitAlg(memoryArray, 100, 3)
    memoryFree(memoryArray, 2, 60)
    firstFitAlg(memoryArray, 200, 4)
    memoryFree(memoryArray, 3, 100)
    memoryFree(memoryArray, 1, 130)
    firstFitAlg(memoryArray, 140, 5)
    firstFitAlg(memoryArray, 60, 6)
    firstFitAlg(memoryArray, 50, 7)
    memoryFree(memoryArray, 6, 60)


    initMemory(memoryArray)
    println("\nWorst Fit\n")
    worstFitAlg(memoryArray, 130, 1)
    worstFitAlg(memoryArray, 60, 2)
    worstFitAlg(memoryArray, 100, 3)
    memoryFree(memoryArray, 2, 60)
    worstFitAlg(memoryArray, 200, 4)
    memoryFree(memoryArray, 3, 100)
    memoryFree(memoryArray, 1, 130)
    worstFitAlg(memoryArray, 140, 5)
    worstFitAlg(memoryArray, 60, 6)
    worstFitAlg(memoryArray, 50, 7)
    memoryFree(memoryArray, 6, 60)


    initMemory(memoryArray)
    println("\nBest Fit\n")
    bestFitAlg(memoryArray, 130, 1)
    bestFitAlg(memoryArray, 60, 2)
    bestFitAlg(memoryArray, 100, 3)
    memoryFree(memoryArray, 2, 60)
    bestFitAlg(memoryArray, 200, 4)
    memoryFree(memoryArray, 3, 100)
    memoryFree(memoryArray, 1, 130)
    bestFitAlg(memoryArray, 140, 5)
    bestFitAlg(memoryArray, 60, 6)
    bestFitAlg(memoryArray, 50, 7)
    memoryFree(memoryArray, 6, 60)

    initMemory(memoryArray)
    var memoryList:MutableList<MemoryModel> = MutableList<MemoryModel>(1,{index -> MemoryModel(640,0) })
    println("\nFist Fit\n")
    printMem(memoryArray)
    newFirstFitAlg(memoryArray, 130, 1,memoryList)
    newFirstFitAlg(memoryArray, 60, 2,memoryList)
    newFirstFitAlg(memoryArray, 100, 3,memoryList)
    memoryFree(memoryArray, 2, 60,memoryList)
    newFirstFitAlg(memoryArray, 200, 4,memoryList)
    memoryFree(memoryArray, 3, 100,memoryList)
    memoryFree(memoryArray, 1, 130,memoryList)
    newFirstFitAlg(memoryArray, 140, 5,memoryList)
    newFirstFitAlg(memoryArray, 60, 6,memoryList)
    newFirstFitAlg(memoryArray, 50, 7,memoryList)
    memoryFree(memoryArray, 6, 60,memoryList)


    initMemory(memoryArray)
    memoryList = MutableList<MemoryModel>(1,{index -> MemoryModel(640,0) })
    println("\nBest Fit\n")
    newBestFitAlg(memoryArray, 130, 1,memoryList)
    newBestFitAlg(memoryArray, 60, 2,memoryList)
    newBestFitAlg(memoryArray, 100, 3,memoryList)
    memoryFree(memoryArray, 2, 60,memoryList)
    newBestFitAlg(memoryArray, 200, 4,memoryList)
    memoryFree(memoryArray, 3, 100,memoryList)
    memoryFree(memoryArray, 1, 130,memoryList)
    newBestFitAlg(memoryArray, 140, 5,memoryList)
    newBestFitAlg(memoryArray, 60, 6,memoryList)
    newBestFitAlg(memoryArray, 50, 7,memoryList)
    memoryFree(memoryArray, 6, 60,memoryList)
}