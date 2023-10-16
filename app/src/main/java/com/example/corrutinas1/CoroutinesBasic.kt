package com.example.corrutinas1

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

const val SEPARADOR = "********************"
fun main(){
   // globalScope()
    //suspendFun()
    newTopic("Constructores de corrutinas")
   // cRunBlocking()
   // cLaunch()
    //cAsync()
   // job()
    readLine()
}

fun job() {
    runBlocking {
        newTopic("Job")
       val job = launch {
            startMssg()
            delay(someTime())
            println("job.....")
            finishMsg()
        }
        println("Job: $job")
        delay(4_000)
        println("isActive: ${job.isActive}")
        println("isCancelled: ${job.isCancelled}")
        println("isCompleted: ${job.isCompleted}")
    }
}
fun cAsync() {
    runBlocking {
        newTopic("Async")
        async {
            startMssg()
            delay(someTime())
            println("Async.....")
            finishMsg()
        }
    }
}
fun cLaunch() {
    runBlocking {
        newTopic("Launch")
        launch {
            startMssg()
            delay(someTime())
            println("Launch.....")
            finishMsg()
        }
    }
}
fun cRunBlocking() {
    newTopic("RunBlocking")
    runBlocking {
        startMssg()
        println("RunBlocking...")
        finishMsg()
    }
}
fun suspendFun() {
    newTopic("suspend")
    Thread.sleep(someTime())
    //delay(someTime())
    GlobalScope.launch(){
        delay(someTime())
    }
}
fun newTopic(topic: String){
    println("${SEPARADOR} + ${topic} + ${SEPARADOR}")
}
fun globalScope() {
    newTopic("Global Scope")
    GlobalScope.launch{
        startMssg()
        delay(someTime())
        println("Mi corrutina")
        finishMsg()
    }
}
fun startMssg() {
    println("Comenzando corrutina -${Thread.currentThread().name}-")
}
fun finishMsg() {
    println("Corrutina -${Thread.currentThread().name}- finalizada")
}
