package zb.ru.bzionservice.model

import zb.ru.bzionservice.data.soap.dto.model.ContainerIonDto

data class ContainerTransactionNotice(
    val transactionId: String,
    val transactionDate: String,
    val transactionStatus: String,
    val user: String,
    val container: Container
)
