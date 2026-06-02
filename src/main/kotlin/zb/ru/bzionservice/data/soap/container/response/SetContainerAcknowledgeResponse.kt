package zb.ru.bzionservice.data.soap.container.response

import jakarta.xml.bind.annotation.*
import zb.ru.bzionservice.data.soap.container.ContainerEndpoint
import zb.ru.bzionservice.data.soap.dto.model.ContainerTransactionIonDto

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = arrayOf(""))
@XmlRootElement(namespace = ContainerEndpoint.NAMESPACE_URI, name = "SetContainerAcknowledgeResponse")
class SetContainerAcknowledgeResponse {
    @XmlElement(required = true, namespace = ContainerEndpoint.NAMESPACE_URI)
    protected var noted: String = "resp... ok, got it"
    fun getContainer(): String {
        return noted
    }

    fun setContainer(value: String) {
        noted = value
        println("response to client")
    }
}