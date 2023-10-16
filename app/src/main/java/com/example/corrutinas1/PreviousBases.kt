package com.example.corrutinas1

import kotlin.concurrent.thread
import kotlin.random.Random

fun main(){
    lambda()
    threads()
}
fun lambda(){
    println(multi(2, 3))
    multiLambda(2, 3) { result ->
        println(result)
    }
}
fun multiLambda(x: Int, y: Int, callback : (result : Int)-> Unit){
    callback(x*y)
}
fun multi(x: Int, y: Int): Int {
return x * y
}
fun threads(){
    println(multiThread(2,3))
    multiThreadLambda(2,5){result ->
        println(result)
    }
}

fun multiThread(x: Int, y: Int): Int {
    var result = 0
    thread{
        Thread.sleep(someTime())
        result = x*y
    }
    Thread.sleep(2_100)
    return result
}
fun multiThreadLambda(x: Int, y: Int, callback : (result : Int)-> Unit){
    var result = 0
    thread{
        Thread.sleep(someTime())
        result = x*y
        callback(result)
    }
}
fun someTime(): Long = Random.nextLong(500, 2_000)
