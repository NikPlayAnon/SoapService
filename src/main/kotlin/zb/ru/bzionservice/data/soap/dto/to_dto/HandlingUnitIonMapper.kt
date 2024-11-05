package zb.ru.bzionservice.data.soap.dto.to_dto

import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.data.soap.dto.Mapper
import zb.ru.bzionservice.data.soap.dto.model.HandlingUnitIonDto

class HandlingUnitIonMapper : Mapper<HandlingUnit, HandlingUnitIonDto> {
    override fun transform(source: HandlingUnit?): HandlingUnitIonDto = HandlingUnitIonDto(
            source!!.id,
            source.length,
            source.width,
            source.warehouse,
            source.location,
            source.sequence,
            source.status,
            source.comment
    )
}