package br.com.estudo.forum.service

import br.com.estudo.forum.model.Curso
import br.com.estudo.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        var usuario = Usuario(
            id = 1,
            nome = "Paula de Souza",
            email = "paula@email.com"
        )

        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter({ u ->
            u.id == id
        }).findFirst().get()
    }

    fun listar(): List<Usuario> {
        return usuarios
    }
}
