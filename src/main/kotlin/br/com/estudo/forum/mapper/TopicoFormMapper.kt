package br.com.estudo.forum.mapper

import br.com.estudo.forum.dto.NovoTopicoForm
import br.com.estudo.forum.dto.TopicoView
import br.com.estudo.forum.model.Topico
import br.com.estudo.forum.service.CursoService
import br.com.estudo.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper (
     private val cursoService: CursoService,
     private val autorService: UsuarioService,):
     Mapper<NovoTopicoForm,Topico> {

    override fun mapper(t: NovoTopicoForm): Topico {
          return Topico(
              titulo = t.titulo,
              mensagem = t.mensagem,
              curso = cursoService.buscarPorId(t.idCurso),
              autor = autorService.buscarPorId(t.idAutor)
          )
    }

}
