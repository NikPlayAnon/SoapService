package zb.ru.bzionservice.data.rabbit.mapper.fromRabbit.container

import zb.ru.bzionservice.data.rabbit.dto.container.ContainerNoticeRabbitDto
import zb.ru.bzionservice.data.rabbit.mapper.Mapper
import zb.ru.bzionservice.model.Container

class ContainerNoticeFromRabbit: Mapper<ContainerNoticeRabbitDto, Container> {
    override fun transform(source: ContainerNoticeRabbitDto?): Container = Container(
        code = source!!.code,
        warehouseCode = source.warehouseCode,
        binCode = source.binCode,
        errors = null
    )
}
