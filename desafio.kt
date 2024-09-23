enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    // Lista mutável de inscritos
    val inscritos = mutableListOf<Usuario>()
    
    // Função para matricular um usuário na formação
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome")
    }

    // Função para exibir os inscritos
    fun exibirInscritos() {
        println("Lista de inscritos na formação $nome:")
        inscritos.forEach { println(it.nome) }
    }

    // Função para exibir detalhes da formação
    fun exibirDetalhes() {
        println("Formação: $nome | Nível: $nivel")
        println("Conteúdos:")
        conteudos.forEach { println("${it.nome} - Duração: ${it.duracao} minutos") }
        println("Total de inscritos: ${inscritos.size}")
    }
}

fun main() {
    // Criando alguns usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    val usuario3 = Usuario("Carlos")

    // Criando conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Kotlin Básico", 90)
    val conteudo2 = ConteudoEducacional("Programação Funcional em Kotlin", 120)
    val conteudo3 = ConteudoEducacional("Java Avançado", 180)

    // Criando formações
    val formacao1 = Formacao("Desenvolvimento Kotlin", listOf(conteudo1, conteudo2), Nivel.INTERMEDIARIO)
    val formacao2 = Formacao("Programação Java", listOf(conteudo3), Nivel.DIFICIL)

    // Matriculando usuários nas formações
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao2.matricular(usuario3)

    // Exibindo detalhes das formações
    formacao1.exibirDetalhes()
    formacao2.exibirDetalhes()

    // Exibindo lista de inscritos
    formacao1.exibirInscritos()
    formacao2.exibirInscritos()
}

