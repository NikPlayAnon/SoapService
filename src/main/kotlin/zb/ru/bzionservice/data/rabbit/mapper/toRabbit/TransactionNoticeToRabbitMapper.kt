package zb.ru.bzionservice.data.rabbit.mapper.toRabbit

import zb.ru.bzionservice.model.TransactionNotice
import zb.ru.bzionservice.data.rabbit.dto.transferByLocations.TransactionNoticeRabbitDto
import zb.ru.bzionservice.data.soap.dto.Mapper
import java.time.Instant
import java.time.format.DateTimeFormatter

class TransactionNoticeToRabbitMapper : Mapper<TransactionNotice, TransactionNoticeRabbitDto> {
    override fun transform(source: TransactionNotice?): TransactionNoticeRabbitDto {
        // Parse the input date string to Instant
        val instant = Instant.parse(source!!.datentime)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSS")
        return TransactionNoticeRabbitDto(
            source!!.transactionId,
            source.success,
            formatter.format(instant.atZone(java.time.ZoneOffset.UTC)),
            source.tenantId,
            source?.errorLog
        )
    }
}
//data class AData(val a: String)
//data class ADomain(val a: String)
//data class APresentation(val a: String)
//
//
//
//fun test() {
//    val adata  =AData("a")
//    adata.toDomain()
//}
//fun AData.toDomain(): ADomain =
//        ADomain(
//                a = "f"
//        ) 