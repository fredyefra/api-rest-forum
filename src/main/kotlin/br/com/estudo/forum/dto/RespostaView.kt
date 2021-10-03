package br.com.estudo.forum.dto

import javax.validation.constraints.NotEmpty

data class RespostaView(
    @field:NotEmpty
    val mensagem: String,
    val idAutor: Long,
    val solucao: Boolean,
    val idTopico: Long
)
