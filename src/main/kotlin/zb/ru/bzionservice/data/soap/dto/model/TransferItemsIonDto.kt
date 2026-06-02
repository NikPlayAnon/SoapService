package zb.ru.bzionservice.data.soap.dto.model

import jakarta.xml.bind.annotation.XmlElement
import zb.ru.bzionservice.data.soap.handling.HandlingUnitsEndpoint
import zb.ru.bzionservice.data.soap.transfer.TransferEndpoint

data class TransferItemsIonDto(
    @field:XmlElement(name="transactionId",namespace = TransferEndpoint.NAMESPACE_URI)
    val transactionId: String,
    @field:XmlElement(name="dateAndTime",namespace = TransferEndpoint.NAMESPACE_URI)
    val dateAndTime: String,
    @field:XmlElement(name="actionCode",namespace = TransferEndpoint.NAMESPACE_URI)
    val actionCode: String,
    @field:XmlElement(name="user",namespace = TransferEndpoint.NAMESPACE_URI)
    val user: String?,
    @field:XmlElement(name="transferItem",namespace = TransferEndpoint.NAMESPACE_URI)
    val transferItemList: List<TransferItemIonDto>
) {
}