package zb.ru.bzionservice.data.soap.dto.model

import jakarta.xml.bind.annotation.XmlElement
import zb.ru.bzionservice.data.soap.handling.HandlingUnitsEndpoint
import zb.ru.bzionservice.data.soap.transfer.TransferEndpoint

data class TransferItemIonDto(
    @field:XmlElement(name="warehouse",namespace = TransferEndpoint.NAMESPACE_URI)
    val warehouse: String,
    @field:XmlElement(name="locationSource",namespace = TransferEndpoint.NAMESPACE_URI)
    val locationSource: String,
    @field:XmlElement(name="locationTarget",namespace = TransferEndpoint.NAMESPACE_URI)
    val locationTarget: String,
    @field:XmlElement(name="item",namespace = TransferEndpoint.NAMESPACE_URI)
    val item: String,
    @field:XmlElement(name="lot",namespace = TransferEndpoint.NAMESPACE_URI)
    val lot: String,
    @field:XmlElement(name="quantity",namespace = TransferEndpoint.NAMESPACE_URI)
    val quantity: String
) {
}