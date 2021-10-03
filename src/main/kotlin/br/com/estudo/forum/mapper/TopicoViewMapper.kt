package br.com.estudo.forum.mapper

import br.com.estudo.forum.dto.TopicoView
import br.com.estudo.forum.model.Topico
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class TopicoViewMapper: Mapper<Topico, TopicoView> {

    override fun mapper(t: Topico): TopicoView {
       return TopicoView(
           id = t.id,
           titulo = t.titulo,
           mensagem = t.mensagem,
           dataCriacao = t.dataCriacao,
           statusTopico = t.status
       )
    }
}