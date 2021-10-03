package br.com.estudo.forum.service

import br.com.estudo.forum.dto.NovaRespostaForm
import br.com.estudo.forum.dto.RespostaView
import br.com.estudo.forum.model.Curso
import br.com.estudo.forum.model.Resposta
import br.com.estudo.forum.model.Topico
import br.com.estudo.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class RespostaService(private var respostas: List<Resposta>,
                      private var topicoService: TopicoService ) {

    init {

        val curso = Curso(
            id = 1,
            nome = "Java",
            categoria = "Programacao"
        )

        val autor = Usuario(
            id = 1,
            nome = "Paula de Souza",
            email = "paula@email.com"
        )

        val topico = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Variaveis no Kotlin",
            curso = curso,
            autor = autor
        )

        val resposta = Resposta(
            id = 1,
            mensagem = "Resposta 1",
            autor = autor,
            topico = topico,
            solucao = false
        )

        val resposta2 = Resposta(
            id = 2,
            mensagem = "Resposta 2",
            autor = autor,
            topico = topico,
            solucao = false
        )

        respostas = Arrays.asList(resposta,resposta2)

    }

    fun listar(idTopico: Long): List<Resposta> {
        return respostas.stream().filter { r ->
            r.topico.id == idTopico
        }.collect(Collectors.toList())
    }

    /*fun listar(): List<Resposta> {
        return respostas.stream().map {
                t-> respostaViewMapper.mapper(t) }.collect(Collectors.toList())
    }*/


}