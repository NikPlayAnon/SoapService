package zb.ru.bzionservice.data.soap.dto.model

import jakarta.xml.bind.annotation.*
import zb.ru.bzionservice.data.soap.container.ContainerEndpoint
import zb.ru.bzionservice.data.soap.handling.HandlingUnitsEndpoint

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["code","warehouseCode","binCode"])
data class ContainerIonDto(
    @field:XmlElement(name="code",namespace = ContainerEndpoint.NAMESPACE_URI)
    val code: String,
    @field:XmlElement(name="warehouseCode",namespace = ContainerEndpoint.NAMESPACE_URI)
    val warehouseCode: String?,
    @field:XmlElement(name="binCode",namespace = ContainerEndpoint.NAMESPACE_URI)
    val binCode: String,
    @field:XmlTransient()
    val abortReason: String?

) {

    constructor() : this("","","", "")
}