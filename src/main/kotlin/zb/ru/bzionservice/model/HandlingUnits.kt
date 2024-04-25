package zb.ru.bzionservice.model

data class HandlingUnits(
    val mvid: String,
    val datentime: String,
    val actioncode: String,
    val handlingUnit: List<HandlingUnit>
) {
}