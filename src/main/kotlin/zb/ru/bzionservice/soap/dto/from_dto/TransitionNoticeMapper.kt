package zb.ru.bzionservice.soap.dto.to_dto

import zb.ru.bzionservice.model.TransactionNotice
import zb.ru.bzionservice.soap.dto.Mapper
import zb.ru.bzionservice.soap.dto.model.TransactionNoticeIonDto

class TransactionNoticeMapper: Mapper<TransactionNoticeIonDto, TransactionNotice> {
    override fun transform(source: TransactionNoticeIonDto?): TransactionNotice = TransactionNotice(
        source!!.mvid,
        source.success,
            source.datentime,
            source.actionCodeField,
            source.tenantId,
        source.errorlog
    )
}