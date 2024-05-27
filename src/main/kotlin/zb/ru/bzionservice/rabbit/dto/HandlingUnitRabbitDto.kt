package zb.ru.bzionservice.rabbit.dto

data class HandlingUnitRabbitDto(val handlingUnitId: String,
                                 val cdfHight: String,
                                 val cdfWidth: String,
                                 val warehouse: String,
                                 val cdfLocation: String,
                                 val cdfLocationSegmantNumber: String) {
}