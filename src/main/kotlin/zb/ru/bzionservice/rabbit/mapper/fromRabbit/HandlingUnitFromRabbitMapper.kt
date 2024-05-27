package zb.ru.bzionservice.rabbit.mapper.fromRabbit

import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.soap.dto.Mapper
import zb.ru.bzionservice.rabbit.dto.HandlingUnitRabbitDto

class HandlingUnitFromRabbitMapper : Mapper<HandlingUnitRabbitDto, HandlingUnit> {
//    class HandlingUnitMapper: Mapper<HandlingUnitIonDto, HandlingUnit> {
        override fun transform(source: HandlingUnitRabbitDto?): HandlingUnit = HandlingUnit(
            source!!.handlingUnitId,
            source.cdfHight,
            source.cdfWidth,
            source.warehouse,
            source.cdfLocation,
            source.cdfLocationSegmantNumber
        )
    }