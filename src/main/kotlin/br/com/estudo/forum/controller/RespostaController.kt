package br.com.estudo.forum.controller

import br.com.estudo.forum.dto.NovaRespostaForm
import br.com.estudo.forum.model.Resposta
import br.com.estudo.forum.service.RespostaService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

//@RequestMapping("/topicos/{id}/respostas")
@RestController
@RequestMapping("/topicos/{id}/respostas")
class RespostaController(private val service: RespostaService) {

    @GetMapping
    fun listar(@PathVariable id: Long): List<Resposta> {
        return service.listar(id)
    }

    /*@PostMapping
    fun cadastrar(@PathVariable id:Long, @RequestBody @Valid dto: NovaRespostaForm) {
        service.cadastrar(dto,id)
    }*/
}