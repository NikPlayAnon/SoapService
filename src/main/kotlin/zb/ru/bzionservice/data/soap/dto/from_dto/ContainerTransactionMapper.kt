package zb.ru.bzionservice.data.soap.dto.from_dto

import zb.ru.bzionservice.data.soap.dto.Mapper
import zb.ru.bzionservice.data.soap.dto.model.ContainerNoticeIonDto
import zb.ru.bzionservice.model.ContainerTransactionNotice

class ContainerTransactionMapper : Mapper<ContainerNoticeIonDto, ContainerTransactionNotice> {
    override fun transform(source: ContainerNoticeIonDto?): ContainerTransactionNotice = ContainerTransactionNotice(
        transactionId = source!!.transactionId,
        transactionDate = source.transactionDate,
        transactionStatus = source.transactionStatus,
        container = ContainerMapper().transform(source.container),
        user = source.user
    )
}
