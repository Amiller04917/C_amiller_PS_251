package edu.wccnet.amiller.coroutine

class Data {
    var namesAndDelay = arrayOf<Pair<String, Long>>()

    fun addList(nameDelay: Pair<String, Long>) {
        namesAndDelay += nameDelay
    }

    fun getList(): Array<Pair<String, Long>>{
        return namesAndDelay
    }
}