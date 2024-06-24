package zb.ru.bzionservice.soap.dto.model

import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlType

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
    ]
)
data class HandlingUnitIonDto(
    val huid: String,
    val cdfHght: String,
    val cdfWdth: String,
    val cwar: String,
    val cdfLoca: String,
    val cdfLose: String,
    val status: String,
    val comment: String
) {
}

