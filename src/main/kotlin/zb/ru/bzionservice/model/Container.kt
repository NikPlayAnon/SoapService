package zb.ru.bzionservice.model

data class Container(
    val code: String,
    val warehouseCode: String?,
    var binCode: String,
    val errors: String?
)
