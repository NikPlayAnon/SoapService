package zb.ru.bzionservice.model

data class TransactionNotice(val transactionId: String, val success: Boolean, val errorLog: List<String>?) {
}