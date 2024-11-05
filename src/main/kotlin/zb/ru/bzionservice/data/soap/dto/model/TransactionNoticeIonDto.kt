package zb.ru.bzionservice.data.soap.dto.model

data class TransactionNoticeIonDto(val mvid: String, val success: Boolean, val datentime: String, val actionCodeField: String,var tenantId: String,  val errorlog: List<String>?) {
}