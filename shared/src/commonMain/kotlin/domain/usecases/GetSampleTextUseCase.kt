package domain.usecases

import domain.repositories.TextRepository

class GetSampleTextUseCase(
    private val repository: TextRepository,
) {
    operator fun invoke(): String {
        return repository.getText()
    }
}