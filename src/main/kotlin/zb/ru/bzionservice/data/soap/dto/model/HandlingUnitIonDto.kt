package zb.ru.bzionservice.data.soap.dto.model

import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlElement
import jakarta.xml.bind.annotation.XmlType
import zb.ru.bzionservice.data.soap.handling.HandlingUnitsEndpoint

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "handlingUnit", propOrder = [
        "huid",
        "cdfHght",
        "cdfWdth",
        "cwar",
        "cdfLoca",
        "cdfLose",
        "status",
        "comment"
    ],
    namespace = HandlingUnitsEndpoint.NAMESPACE_URI
)
data class HandlingUnitIonDto(
    @field:XmlElement(name="huid",namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    val huid: String,
    @field:XmlElement(name="cdfHght",namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    val cdfHght: String,
    @field:XmlElement(name="cdfWdth",namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    val cdfWdth: String,
    @field:XmlElement(name="cwar",namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    val cwar: String,
    @field:XmlElement(name="cdfLoca",namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    val cdfLoca: String,
    @field:XmlElement(name="cdfLose",namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    val cdfLose: String,
    @field:XmlElement(name="status",namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    val status: String,
    @field:XmlElement(name="comment",namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    val comment: String
) {
}

