package zb.ru.bzionservice.data.soap.dto.to_dto

import zb.ru.bzionservice.data.soap.dto.Mapper
import zb.ru.bzionservice.data.soap.dto.model.ContainerIonDto
import zb.ru.bzionservice.model.Container

class ContainerIonMapper : Mapper<Container, ContainerIonDto> {
    override fun transform(source: Container?): ContainerIonDto = ContainerIonDto(
        code = source!!.code,
        warehouseCode = source.warehouseCode,
        binCode = source.binCode,
        null
    )
}