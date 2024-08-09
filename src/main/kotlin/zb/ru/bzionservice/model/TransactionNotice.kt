package zb.ru.bzionservice.model

import zb.ru.bzionservice.rabbit.dto.TransactionNoticeRabbitDto

data class TransactionNotice(val transactionId: String, val success: Boolean, val datentime: String, val actionCodeField: String, val tenantId: String, val errorLog: List<String>?) {
}

//fun TransactionNotice.toTransactionNoticeToRabbit(): TransactionNoticeRabbitDto =
//        TransactionNoticeRabbitDto(
//                transactionId = this.transactionId,
//                success = this.success,
//                errorLog = this.errorLog
//        )
