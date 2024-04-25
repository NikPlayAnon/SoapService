package zb.ru.bzionservice.soap.dto

import zb.ru.bzionservice.model.HandlingUnit

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