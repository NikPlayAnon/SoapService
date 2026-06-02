package zb.ru.bzionservice.data.soap.dto.to_dto

import zb.ru.bzionservice.data.soap.dto.Mapper
import zb.ru.bzionservice.data.soap.dto.model.TransferItemsIonDto
import zb.ru.bzionservice.model.TransferItems

class TransferItemsIonMapper: Mapper<TransferItems, TransferItemsIonDto> {
    override fun transform(source: TransferItems?): TransferItemsIonDto = TransferItemsIonDto(
        source!!.transactionId,
        source.dateAndTime,
        source.actionCode,
        source.user,
        source.transferItemList.map { TransferItemIonMapper().transform(it) }
    )
}