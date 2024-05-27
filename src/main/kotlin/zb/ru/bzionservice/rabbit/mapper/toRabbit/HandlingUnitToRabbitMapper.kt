package zb.ru.bzionservice.rabbit.mapper.toRabbit

import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.rabbit.dto.HandlingUnitRabbitDto
import zb.ru.bzionservice.soap.dto.Mapper

class HandlingUnitToRabbitMapper : Mapper<HandlingUnit, HandlingUnitRabbitDto> {
        override fun transform(source: HandlingUnit?): HandlingUnitRabbitDto = HandlingUnitRabbitDto(
            source!!.handlingUnitId,
            source.cdfHight,
            source.cdfWidth,
            source.warehouse,
            source.cdfLocation,
            source.cdfLocationSegmantNumber
        )
    }