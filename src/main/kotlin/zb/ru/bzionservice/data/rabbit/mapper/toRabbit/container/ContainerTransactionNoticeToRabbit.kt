package zb.ru.bzionservice.data.rabbit.mapper.toRabbit.container

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import zb.ru.bzionservice.data.rabbit.dto.container.ContainerNoticeRabbitDto
import zb.ru.bzionservice.data.rabbit.dto.container.ContainerTransactionNoticeRabbitDto
import zb.ru.bzionservice.data.rabbit.mapper.Mapper
import zb.ru.bzionservice.model.ContainerTransaction
import zb.ru.bzionservice.model.ContainerTransactionNotice

class ContainerTransactionNoticeToRabbit : Mapper<ContainerTransactionNotice,ContainerTransactionNoticeRabbitDto> {
    override fun transform(source: ContainerTransactionNotice?): ContainerTransactionNoticeRabbitDto = ContainerTransactionNoticeRabbitDto(
        transactionId = source!!.transactionId.toInt(),
        transactionDate = source.transactionDate,
        transactionStatus = when (source.transactionStatus) {
            "Accepted" -> "COMPLETED"
            else -> "FAILED"
        }.toString(),
        user = source.user,
        abort_reason = source.container.errors?.let {
            if (source.transactionStatus == "Accepted"){
                null
            } else {
                jacksonObjectMapper().readValue(content = it)
            }
        }
    )

}