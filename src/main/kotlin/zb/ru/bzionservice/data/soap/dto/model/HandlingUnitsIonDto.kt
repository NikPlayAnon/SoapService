package zb.ru.bzionservice.data.soap.dto.model

import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlElement
import jakarta.xml.bind.annotation.XmlType
import zb.ru.bzionservice.data.soap.handling.HandlingUnitsEndpoint

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "handlingUnits",
    propOrder = [
        "mvid",
        "datentime",
        "actioncode",
        "user",
        "handlingUnit"
    ],
    namespace = HandlingUnitsEndpoint.NAMESPACE_URI
)
data class HandlingUnitsIonDto(
    @field:XmlElement(name="mvid",namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    val mvid: String,
    @field:XmlElement(name="datentime",namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    val datentime: String,
    @field:XmlElement(name="actioncode",namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    val actioncode: String,
    @field:XmlElement(name="user",namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    val user: String?,
    @field:XmlElement(name="handlingUnit",namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    val handlingUnit: List<HandlingUnitIonDto>) {
}