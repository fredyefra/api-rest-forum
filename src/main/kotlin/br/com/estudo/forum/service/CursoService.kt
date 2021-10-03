package br.com.estudo.forum.service

import br.com.estudo.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService (var cursos: List<Curso>) {

  init {
      val curso1 = Curso(
          id = 1,
          nome = "Kotlin",
          categoria = "Programacao"
      )

      val curso2 = Curso(
          id = 2,
          nome = "Java",
          categoria = "Programacao"
      )

      val curso3 = Curso(
          id = 3,
          nome = "Bancos de Dados",
          categoria = "Normalizacao"
      )

      cursos = Arrays.asList(curso1)
  }

    fun buscarPorId(id:Long): Curso{
        return cursos.stream().filter { curso ->
            curso.id == id
        }.findFirst().get()
    }

    fun listar(): List<Curso>{
        return cursos
    }



}
