package zb.ru.bzionservice.data.rabbit.mapper.fromRabbit

import zb.ru.bzionservice.data.soap.dto.Mapper
import zb.ru.bzionservice.data.rabbit.dto.transferByLocations.TransferItemRabbitDto
import zb.ru.bzionservice.model.TransferItem

class TransferItemFromRabbitMapper : Mapper<TransferItemRabbitDto, TransferItem> {
//    class HandlingUnitMapper: Mapper<HandlingUnitIonDto, HandlingUnit> {
        override fun transform(source: TransferItemRabbitDto?): TransferItem = TransferItem(
            source!!.warehouse,
            source.locationSource,
            source.locationTarget,
            source.item,
            source.lot,
            source.quantity.toString()
        )
    }