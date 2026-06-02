package zb.ru.bzionservice.data.rabbit.mapper.fromRabbit

import zb.ru.bzionservice.data.soap.dto.Mapper
import zb.ru.bzionservice.data.rabbit.dto.transferByLocations.TransferItemsRabbitDto
import zb.ru.bzionservice.model.TransferItems
import java.time.Instant
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class TransferItemsFromRabbitMapper : Mapper<TransferItemsRabbitDto, TransferItems> {
    //    class HandlingUnitsMapper: Mapper<HandlingUnitsIonDto, HandlingUnits> {
    override fun transform(source: TransferItemsRabbitDto?): TransferItems {
        // Define the formatter for the input date
//        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
//        val zonedDateTime = ZonedDateTime.parse(source!!.transaction_date, inputFormatter)
//        // Convert to UTC and format to the desired output format (ISO format)
//        val outputFormatter = DateTimeFormatter.ISO_INSTANT
        return TransferItems(
            source!!.transaction_id,
//            outputFormatter.format(zonedDateTime.toInstant()),
            source.transaction_date,
            "transferItems",
            source.user_login,
            listOf(source.transferItemList)?.map { TransferItemFromRabbitMapper().transform(it) } ?: listOf()
        )
    }
}