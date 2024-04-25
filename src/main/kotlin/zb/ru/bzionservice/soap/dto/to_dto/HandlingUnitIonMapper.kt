package zb.ru.bzionservice.soap.dto.to_dto

import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.soap.dto.Mapper
import zb.ru.bzionservice.soap.dto.model.HandlingUnitIonDto

class HandlingUnitIonMapper: Mapper<HandlingUnit, HandlingUnitIonDto> {
    override fun transform(source: HandlingUnit?): HandlingUnitIonDto = HandlingUnitIonDto(
        source!!.huid,
        source.cdfHght,
        source.cdfWdth,
        source.cwar,
        source.cdfLoca,
        source.cdfLose
    )
}