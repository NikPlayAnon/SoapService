package zb.ru.bzionservice.data.rabbit.mapper.fromRabbit

import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.data.soap.dto.Mapper
import zb.ru.bzionservice.data.rabbit.dto.HandlingUnitsRabbitDto
import zb.ru.bzionservice.data.rabbit.dto.HandlingUnitsUpdateRabbitDto

class HandlingUnitsFromRabbitMapperUpdate: Mapper<HandlingUnitsUpdateRabbitDto, HandlingUnits> {
//    class HandlingUnitsMapper: Mapper<HandlingUnitsIonDto, HandlingUnits> {
        override fun transform(source: HandlingUnitsUpdateRabbitDto?): HandlingUnits = HandlingUnits(
            source!!.transaction_id,
            source.transaction_date,
            "writeOffOfGoods",
            source.user,
            listOf( source.measured_remainder)?.map { HandlingUnitFromRabbitMapper().transform(it)} ?: listOf()
        )
    }