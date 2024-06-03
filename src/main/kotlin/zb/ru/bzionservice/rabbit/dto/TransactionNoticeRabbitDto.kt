package zb.ru.bzionservice.rabbit.dto

class TransactionNoticeRabbitDto(val transactionId: String, val success: Boolean, val errorLog: List<String>?) {
}