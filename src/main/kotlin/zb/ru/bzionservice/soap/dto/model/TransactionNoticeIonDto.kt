package zb.ru.bzionservice.soap.dto.model

data class TransactionNoticeIonDto(val mvid: String, val success: Boolean, val datentime: String,var tenantId: String,  val errorlog: List<String>?) {
}