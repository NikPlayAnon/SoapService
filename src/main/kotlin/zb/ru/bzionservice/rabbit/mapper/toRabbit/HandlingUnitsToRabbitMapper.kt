package zb.ru.bzionservice.rabbit.mapper.toRabbit

import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.soap.dto.Mapper
import zb.ru.bzionservice.rabbit.dto.HandlingUnitsRabbitDto
import zb.ru.bzionservice.rabbit.dto.HandlingUnitRabbitDto


class HandlingUnitsToRabbitMapper : Mapper<HandlingUnits, HandlingUnitsRabbitDto> {
    override fun transform(source: HandlingUnits?): HandlingUnitsRabbitDto = HandlingUnitsRabbitDto(
        source!!.transactionId,
        source.dateAndTime,
        source.actionCode,
        source.handlingUnit.map { HandlingUnitToRabbitMapper().transform(it) }
    )
}