package me.hyuni.cancellationAndTimeouts002

import kotlinx.coroutines.*

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 10) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting")
    job.cancelAndJoin()
    println("main: Now I can quit")
}