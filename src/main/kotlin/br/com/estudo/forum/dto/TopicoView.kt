package br.com.estudo.forum.dto

import br.com.estudo.forum.model.StatusTopico
import java.time.LocalDateTime


data class TopicoView (
     val id : Long?,
     val titulo: String,
     val mensagem: String,
     val statusTopico: StatusTopico,
     val dataCriacao: LocalDateTime = LocalDateTime.now()
     )