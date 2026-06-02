package zb.ru.bzionservice.data.rabbit.mapper.fromRabbit.container

import zb.ru.bzionservice.data.rabbit.dto.container.ContainerTransactionNoticeRabbitDto
import zb.ru.bzionservice.data.rabbit.dto.container.ContainerTransactionRabbitDto
import zb.ru.bzionservice.data.rabbit.mapper.Mapper
import zb.ru.bzionservice.model.ContainerTransaction

class ContainerTransactionFromRabbit : Mapper<ContainerTransactionRabbitDto, ContainerTransaction> {
    override fun transform(source: ContainerTransactionRabbitDto?): ContainerTransaction = ContainerTransaction(
        transactionId = source!!.transactionId.toString(),
        transactionDate = source.transactionDate,
        transactionStatus = source.transactionStatus,
        user = source.user,
        container = ContainerNoticeFromRabbit().transform(source.container)

    )
}