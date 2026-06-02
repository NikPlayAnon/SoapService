package zb.ru.bzionservice.data.soap.dto.from_dto

import zb.ru.bzionservice.data.soap.dto.Mapper
import zb.ru.bzionservice.data.soap.dto.model.ContainerIonDto
import zb.ru.bzionservice.model.Container

class ContainerMapper: Mapper<ContainerIonDto,Container> {
    override fun transform(source: ContainerIonDto?): Container = Container(
        code = source!!.code,
        warehouseCode = source.warehouseCode,
        binCode = source.binCode,
        errors = source.abortReason
    )

}
