package zb.ru.bzionservice.data.rabbit.mapper.fromRabbit

import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.data.soap.dto.Mapper
import zb.ru.bzionservice.data.rabbit.dto.HandlingUnitsRabbitDto

class HandlingUnitsFromRabbitMapper: Mapper<HandlingUnitsRabbitDto, HandlingUnits> {
//    class HandlingUnitsMapper: Mapper<HandlingUnitsIonDto, HandlingUnits> {
        override fun transform(source: HandlingUnitsRabbitDto?): HandlingUnits = HandlingUnits(
            source!!.transaction_id,
            source.transaction_date,
            "inventoryManagement",
            source.user,
        source.measured_remainder?.map { HandlingUnitFromRabbitMapper().transform(it)} ?: listOf()
        )
    }