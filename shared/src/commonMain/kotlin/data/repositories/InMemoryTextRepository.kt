package data.repositories

import domain.repositories.TextRepository

class InMemoryTextRepository: TextRepository {
    override fun getText(): String {
        return "サンプルテキストです。"
    }
}