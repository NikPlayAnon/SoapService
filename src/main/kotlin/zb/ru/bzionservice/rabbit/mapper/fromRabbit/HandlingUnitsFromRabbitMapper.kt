package zb.ru.bzionservice.rabbit.mapper.fromRabbit

import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.soap.dto.Mapper
import zb.ru.bzionservice.rabbit.dto.HandlingUnitRabbitDto
import zb.ru.bzionservice.rabbit.dto.HandlingUnitsRabbitDto

class HandlingUnitsFromRabbitMapper: Mapper<HandlingUnitsRabbitDto, HandlingUnits> {
//    class HandlingUnitsMapper: Mapper<HandlingUnitsIonDto, HandlingUnits> {
        override fun transform(source: HandlingUnitsRabbitDto?): HandlingUnits = HandlingUnits(
            source!!.transactionId,
            source.dateAndTime,
            source.actionCode,
            source.user,
            source.handlingUnit.map { HandlingUnitFromRabbitMapper().transform(it)}
        )
    }