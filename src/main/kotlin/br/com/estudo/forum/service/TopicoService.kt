package br.com.estudo.forum.service

import br.com.estudo.forum.dto.AtualizarTopicoForm
import br.com.estudo.forum.dto.NovoTopicoForm
import br.com.estudo.forum.dto.TopicoView
import br.com.estudo.forum.exception.LancarNotFoundException
import br.com.estudo.forum.mapper.TopicoFormMapper
import br.com.estudo.forum.mapper.TopicoViewMapper
import br.com.estudo.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList<Topico>(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val message: String = "TÓPICO NÃO ENCONTRADO!!"
    ) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map {
                t-> topicoViewMapper.mapper(t) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter{
                t -> t.id == id
        }.findFirst().orElseThrow{(LancarNotFoundException(message))}
        return topicoViewMapper.mapper(topico)
    }

    fun cadastrar(form: NovoTopicoForm):TopicoView {
        val topico = topicoFormMapper.mapper(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return topicoViewMapper.mapper(topico)
    }

    fun atualizar(form: AtualizarTopicoForm): TopicoView {
        val topico = topicos.stream().filter{
                t -> t.id == form.id
        }.findFirst().orElseThrow{(LancarNotFoundException(message))}
        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado)
       return topicoViewMapper.mapper(topicoAtualizado)

    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter{
                t -> t.id == id
        }.findFirst().orElseThrow{(LancarNotFoundException(message))}
        topicos = topicos.minus(topico)

    }
}