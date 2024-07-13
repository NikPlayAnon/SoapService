package zb.ru.bzionservice.rabbit.mapper.fromRabbit

import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.soap.dto.Mapper
import zb.ru.bzionservice.rabbit.dto.HandlingUnitRabbitDto

class HandlingUnitFromRabbitMapper : Mapper<HandlingUnitRabbitDto, HandlingUnit> {
//    class HandlingUnitMapper: Mapper<HandlingUnitIonDto, HandlingUnit> {
        override fun transform(source: HandlingUnitRabbitDto?): HandlingUnit = HandlingUnit(
            source!!.id,
            source.length.toString(),
            source.width.toString(),
            source.warehouse,
            source.location,
            source.sequence.toString(),
//            source.status,
            status =  when(source.status){
                2 -> "in.kocz"
                3 -> "in.msch"
                4 -> "used"
                else -> "created"
            },
            source.comment
        )
    }