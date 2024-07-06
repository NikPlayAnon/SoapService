package zb.ru.bzionservice.soap.dto.to_dto

import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.soap.dto.Mapper
import zb.ru.bzionservice.soap.dto.model.HandlingUnitsIonDto

class HandlingUnitsMapper: Mapper<HandlingUnitsIonDto, HandlingUnits> {
        override fun transform(source: HandlingUnitsIonDto?): HandlingUnits = HandlingUnits(
            source!!.mvid,
            source.datentime,
            source.actioncode,
            source.user,
            source.handlingUnit.map { HandlingUnitMapper().transform(it)}
        )
}