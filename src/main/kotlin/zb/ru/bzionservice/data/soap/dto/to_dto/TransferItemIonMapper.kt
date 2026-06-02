package zb.ru.bzionservice.data.soap.dto.to_dto

import zb.ru.bzionservice.data.soap.dto.Mapper
import zb.ru.bzionservice.data.soap.dto.model.TransferItemIonDto
import zb.ru.bzionservice.model.TransferItem

class TransferItemIonMapper : Mapper<TransferItem, TransferItemIonDto> {
    override fun transform(source: TransferItem?): TransferItemIonDto = TransferItemIonDto(
        source!!.warehouse,
        source.locationSource,
        source.locationTarget,
        source.item,
        source.lot,
        source.quantity
    )
}