package zb.ru.bzionservice.model

import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlType

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "handlingUnits", propOrder = [
        "mvid",
        "datentime",
        "actioncode",
        "handlingUnit"
    ]
)
data class HandlingUnits(val TransactionId: String, val dateAndTime: String, val actionCode: String, val handlingUnit: List<HandlingUnit> ) {
}