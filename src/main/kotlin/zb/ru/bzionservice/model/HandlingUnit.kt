package zb.ru.bzionservice.model

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
        "cdfLose"
    ]
)
data class HandlingUnit(
    val handlingUnitID: String,
    val customHight: String,
    val customWidth: String,
    val warehouse: String,
    val customWerehouseLocation: String,
    val customNumberInPlace: String
) {
}