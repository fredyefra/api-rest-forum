package br.com.estudo.forum.dto

import javax.validation.constraints.NotEmpty

data class NovaRespostaForm(
    @field:NotEmpty
    val mensagem: String,
    val idAutor: Long,
    val solucao: Boolean,
    val idTopico: Long
    )
