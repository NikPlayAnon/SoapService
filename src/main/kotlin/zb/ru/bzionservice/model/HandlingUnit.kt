package zb.ru.bzionservice.model

data class HandlingUnit(
    val handlingUnitId: String,
    val cdfHight: String,
    val cdfWidth: String,
    val warehouse: String,
    val cdfLocation: String,
    val cdfLocationSegmantNumber: String
) {
}