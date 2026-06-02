package zb.ru.bzionservice.model

data class TransferItem(
    val warehouse: String,
    val locationSource: String,
    val locationTarget: String,
    val item: String,
    val lot: String,
    val quantity: String
) {
}