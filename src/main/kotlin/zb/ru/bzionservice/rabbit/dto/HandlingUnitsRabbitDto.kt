package zb.ru.bzionservice.rabbit.dto

import zb.ru.bzionservice.model.HandlingUnit

data class HandlingUnitsRabbitDto(val transactionId: String,
                                  val dateAndTime: String,
                                  val actionCode: String,
                                  val handlingUnit: List<HandlingUnitRabbitDto>) {
}