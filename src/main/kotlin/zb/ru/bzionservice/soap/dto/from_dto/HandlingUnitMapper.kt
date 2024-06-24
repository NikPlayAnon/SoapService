package zb.ru.bzionservice.soap.dto.to_dto

import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.soap.dto.Mapper
import zb.ru.bzionservice.soap.dto.model.HandlingUnitIonDto

class HandlingUnitMapper : Mapper<HandlingUnitIonDto, HandlingUnit> {
    override fun transform(source: HandlingUnitIonDto?): HandlingUnit = HandlingUnit(
            source!!.huid,
            source.cdfHght,
            source.cdfWdth,
            source.cwar,
            source.cdfLoca,
            source.cdfLose,
            source.status,
            source.comment
    )
}