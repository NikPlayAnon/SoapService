package zb.ru.bzionservice.rabbit.dto

data class TransactionNoticeRabbitDto(val transactionId: String, val success: Boolean, val errorLog: List<String>?) {
}