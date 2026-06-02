package zb.ru.bzionservice.model

data class TransferItems(
    val transactionId: String,
    val dateAndTime: String,
    val actionCode: String,
    val user: String?,
    val transferItemList: List<TransferItem>
) {
}