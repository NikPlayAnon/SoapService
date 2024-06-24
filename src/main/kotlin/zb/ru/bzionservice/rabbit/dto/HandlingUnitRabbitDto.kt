package zb.ru.bzionservice.rabbit.dto

data class HandlingUnitRabbitDto(val id: String,
                                 val length: String,
                                 val width: String,
                                 val warehouse: String,
                                 val location: String,
                                 val sequence: String,
                                 val status: String,
                                 val comment: String
        ) {
}