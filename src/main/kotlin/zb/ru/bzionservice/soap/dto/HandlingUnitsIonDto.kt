package zb.ru.bzionservice.soap.dto

import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlType
import zb.ru.bzionservice.model.HandlingUnit
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "handlingUnits", propOrder = [
        "mvid",
        "datentime",
        "actioncode",
        "handlingUnit"
    ]
)
data class HandlingUnitsIonDto(val mvid: String, val datentime: String, val actioncode: String, val handlingUnit: List<HandlingUnitIonDto>) {
}