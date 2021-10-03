package br.com.estudo.forum.model

import br.com.estudo.forum.dto.TopicoView
import java.time.LocalDateTime

data class Resposta(
        /*val id:Long?, BKP não apagar
        val mensagem: String,
        val dataCriacao: LocalDateTime = LocalDateTime.now(),
        val autor: Usuario,
        val topico: Topico,
        val solucao: Boolean*/

        val id:Long? = null,
        val mensagem: String,
        val dataCriacao: LocalDateTime = LocalDateTime.now(),
        val autor: Usuario,
        val topico: Topico,
        val solucao: Boolean


        )
