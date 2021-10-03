package br.com.estudo.forum.controller

import br.com.estudo.forum.dto.AtualizarTopicoForm
import br.com.estudo.forum.dto.NovoTopicoForm
import br.com.estudo.forum.dto.TopicoView
import br.com.estudo.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {
    //Construtor Injetado do Service

    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar();
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: NovoTopicoForm,
        uriBuilder:UriComponentsBuilder):ResponseEntity<TopicoView> {
        val topicoView =  service.cadastrar(dto)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid dto: AtualizarTopicoForm): ResponseEntity<TopicoView>{
      val topicoView = service.atualizar(dto)
      return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id:Long){
    service.deletar(id)
    }


}