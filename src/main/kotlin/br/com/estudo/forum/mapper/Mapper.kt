package br.com.estudo.forum.mapper

interface Mapper<T, U> {

    fun mapper(t:T):U

}
