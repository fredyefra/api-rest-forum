/*
package br.com.estudo.forum.mapper

import br.com.estudo.forum.dto.NovaRespostaForm
import br.com.estudo.forum.model.Resposta
import br.com.estudo.forum.service.TopicoService
import br.com.estudo.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class RespostaFormMapper (private val autorService: UsuarioService,
                          private val topicoService: TopicoService):
                          Mapper<NovaRespostaForm,Resposta> {

    override fun mapper(r: NovaRespostaForm): Resposta {
     return  Resposta(
         //id = r.id,
         mensagem = r.mensagem,
         autor = autorService.buscarPorId(r.idAutor),
         solucao = r.solucao,
         topico = topicoService.buscarPorId(r.idTopico)
     )
    }
    }*/
