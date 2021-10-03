package br.com.estudo.forum.exception

import java.lang.RuntimeException

class LancarNotFoundException(message: String?) : RuntimeException(message) {
}