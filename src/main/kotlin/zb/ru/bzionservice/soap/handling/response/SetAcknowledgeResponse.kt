package zb.ru.bzionservice.soap.handling.response

import jakarta.xml.bind.annotation.*
import zb.ru.bzionservice.soap.handling.HandlingUnitsEndpoint

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = arrayOf(""))
@XmlRootElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, name = "SetAcknowledgeResponse")
class SetAcknowledgeResponse {
    @XmlElement(required = true, namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    protected var noted: String = "resp..."
    fun getAcknowledge(): String {
        return noted
    }

    fun setAcknowledge(value: String) {
        noted = value
    }
}

