package zb.ru.bzionservice.rabbit.mapper.toRabbit

import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.model.TransactionNotice
import zb.ru.bzionservice.rabbit.dto.HandlingUnitRabbitDto
import zb.ru.bzionservice.rabbit.dto.TransactionNoticeRabbitDto
import zb.ru.bzionservice.soap.dto.Mapper

class TransactionNoticeToRabbitMapper: Mapper<TransactionNotice, TransactionNoticeRabbitDto> {
    override fun transform(source: TransactionNotice?): TransactionNoticeRabbitDto =
            TransactionNoticeRabbitDto(
                    source!!.transactionId,
                    source.success,
                    source.datentime,
                    source.tenantId,
                    source?.errorLog
            )
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