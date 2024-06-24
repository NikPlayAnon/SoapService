package zb.ru.bzionservice.model

data class HandlingUnits(
    val transactionId: String,
    val dateAndTime: String,
    val actionCode: String,
    val measured_remainders: List<HandlingUnit>
) {
}