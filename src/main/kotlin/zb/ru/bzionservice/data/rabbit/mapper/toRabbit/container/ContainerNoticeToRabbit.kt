package zb.ru.bzionservice.data.rabbit.mapper.toRabbit.container

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import zb.ru.bzionservice.data.rabbit.dto.container.ContainerNoticeRabbitDto
import zb.ru.bzionservice.data.rabbit.mapper.Mapper
import zb.ru.bzionservice.model.Container

class ContainerNoticeToRabbit: Mapper<Container,ContainerNoticeRabbitDto> {
    override fun transform(source: Container?): ContainerNoticeRabbitDto = ContainerNoticeRabbitDto(
        code = source!!.code,
        warehouseCode = source.warehouseCode,
        binCode = source.binCode,
        source.errors?.let { jacksonObjectMapper().readValue(content = it) }
    )
}