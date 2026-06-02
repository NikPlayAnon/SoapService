package zb.ru.bzionservice.data.soap.dto.model

data class ContainerNoticeIonDto(
    val transactionId: String,
    val transactionDate: String,
    val transactionStatus: String,
    val user: String,
    val container: ContainerIonDto
)
