package zb.ru.bzionservice.data.soap.dto.to_dto

import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.data.soap.dto.Mapper
import zb.ru.bzionservice.data.soap.dto.model.HandlingUnitsIonDto

class HandlingUnitsIonMapper: Mapper<HandlingUnits, HandlingUnitsIonDto> {
        override fun transform(source: HandlingUnits?): HandlingUnitsIonDto = HandlingUnitsIonDto(
            source!!.transactionId,
            source.dateAndTime,
            source.actionCode,
            source.user,
            source.measured_remainders.map { HandlingUnitIonMapper().transform(it)}
        )
}