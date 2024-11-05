package zb.ru.bzionservice.data.soap.dto.model

import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlType

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "handlingUnits", propOrder = [
        "mvid",
        "datentime",
        "actioncode",
        "user",
        "handlingUnit"
    ]
)
data class HandlingUnitsIonDto(val mvid: String, val datentime: String, val actioncode: String, val user: String?, val handlingUnit: List<HandlingUnitIonDto>) {
}