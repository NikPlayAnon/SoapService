package zb.ru.bzionservice.soap.dto.to_dto

import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.soap.dto.Mapper
import zb.ru.bzionservice.soap.dto.model.HandlingUnitsIonDto

class HandlingUnitsIonMapper: Mapper<HandlingUnits, HandlingUnitsIonDto> {
        override fun transform(source: HandlingUnits?): HandlingUnitsIonDto = HandlingUnitsIonDto(
            source!!.transactionId,
            source.dateAndTime,
            source.actionCode,
            source.measured_remainders.map { HandlingUnitIonMapper().transform(it)}
        )
}