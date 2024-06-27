package zb.ru.bzionservice.rabbit.mapper.fromRabbit

import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.soap.dto.Mapper
import zb.ru.bzionservice.rabbit.dto.HandlingUnitRabbitDto

class HandlingUnitFromRabbitMapper : Mapper<HandlingUnitRabbitDto, HandlingUnit> {
//    class HandlingUnitMapper: Mapper<HandlingUnitIonDto, HandlingUnit> {
        override fun transform(source: HandlingUnitRabbitDto?): HandlingUnit = HandlingUnit(
            source!!.id,
            source.length,
            source.width,
            source.warehouse,
            source.location,
            source.sequence,
//            source.status,
            status =  when(source.status){
                "1" -> "created"
                "2" -> "in.kocz"
                "3" -> "in.msch"
                else -> "used"
            },
            source.comment
        )
    }