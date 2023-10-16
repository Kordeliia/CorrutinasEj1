package com.example.corrutinas1

import android.content.res.Resources.Theme
import com.cursosant.fundamentoscorrutinas.startMsg
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.random.Random

fun main(){
    //dispatchers()
    //nested()
    //changeWithContext()
    //sequences()
    basicFlows()
}
fun basicFlows(){
    newTopic("Flows Basicos")
    runBlocking {
        launch { getDataByFlow().collect{ println(it)} }
        launch {
            (1..50).forEach {
                delay(someTime()/10)
                println("Tarea 2")
            }
        }
    }
}
fun getDataByFlow() : Flow<Float> {
    return flow{
        (1..5).forEach{
            println("procesando datos....")
            delay(someTime())
            emit (20 + it +Random.nextFloat())
        }
    }
}
fun sequences() {
    newTopic("SEQUENCES")
    getDataBySeq().forEach { println("$it ") }
}

fun getDataBySeq() :Sequence<Float> {
    return sequence{
        (1..5).forEach{
            println("Procesando datos....")
            Thread.sleep(someTime())
            yield(20+it+ Random.nextFloat())
        }

    }
}

fun changeWithContext() {
    runBlocking {
        newTopic("withContext")
        startMsg()
        withContext(newSingleThreadContext("Cursos Androdid")){
            startMsg()
            delay(someTime())
            println("Cursos ANT")
            finishMsg()
        }
        finishMsg()
    }
}

fun nested() {
    runBlocking {
        newTopic("Nested Coroutines")
        val job = launch{
            startMsg()
        }
        launch{
            startMsg()
            delay(someTime())
            println("Tarea2")
            finishMsg()
        }
        launch(Dispatchers.IO){
            startMssg()
            launch(newSingleThreadContext("Luli")) {
                startMsg()
                println("Otra segunda o cuarta tarea")
                finishMsg()
            }
            delay(someTime())
            println("Tarea en el servidor")
            finishMsg()
        }
        finishMsg()
    }
}

fun dispatchers() {
    runBlocking {
        newTopic("Dispatchers")
        launch{
            startMssg()
            println("None")
            finishMsg()
        }
        launch (Dispatchers.IO){
            startMssg()
            println("IO")
            finishMsg()
        }
    }
}
