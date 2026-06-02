package zb.ru.bzionservice.model

data class ContainerTransaction(val transactionId: String, val transactionDate: String, val transactionStatus: String, val user: String, val container: Container)
