package zb.ru.bzionservice.soap.dto

import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.model.HandlingUnits

class HandlingUnitsIonMapper: Mapper<HandlingUnits, HandlingUnitsIonDto> {
        override fun transform(source: HandlingUnits?): HandlingUnitsIonDto =HandlingUnitsIonDto(
            source!!.mvid,
            source.datentime,
            source.actioncode,
            source.handlingUnit.map {HandlingUnitIonMapper().transform(it)}
        )
}