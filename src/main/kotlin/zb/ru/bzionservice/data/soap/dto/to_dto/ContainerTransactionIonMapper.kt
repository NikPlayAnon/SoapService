package zb.ru.bzionservice.data.soap.dto.to_dto

import zb.ru.bzionservice.data.soap.dto.Mapper
import zb.ru.bzionservice.data.soap.dto.model.ContainerTransactionIonDto
import zb.ru.bzionservice.model.ContainerTransaction

class ContainerTransactionIonMapper : Mapper<ContainerTransaction, ContainerTransactionIonDto> {
    override fun transform(source: ContainerTransaction?): ContainerTransactionIonDto = ContainerTransactionIonDto(
        transactionId = source!!.transactionId,
        transactionDate = source.transactionDate,
        user = source.user,
        container = ContainerIonMapper().transform(source.container)
    )
}