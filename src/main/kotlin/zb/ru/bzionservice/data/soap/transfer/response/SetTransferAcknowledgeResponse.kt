package zb.ru.bzionservice.data.soap.transfer.response

import jakarta.xml.bind.annotation.*
import zb.ru.bzionservice.data.soap.handling.HandlingUnitsEndpoint
import zb.ru.bzionservice.data.soap.transfer.TransferEndpoint

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = arrayOf(""))
@XmlRootElement(namespace = TransferEndpoint.NAMESPACE_URI, name = "SetTransferAcknowledgeResponse")
class SetTransferAcknowledgeResponse {
    @XmlElement(required = true, namespace = TransferEndpoint.NAMESPACE_URI)
    protected var noted: String = "resp... ok, got it"
    fun getAcknowledge(): String {
        return noted
    }

    fun setAcknowledge(value: String) {
        noted = value
    }
}

