package zb.ru.bzionservice.data.soap.container.response

import jakarta.xml.bind.annotation.*
import zb.ru.bzionservice.data.soap.container.ContainerEndpoint
import zb.ru.bzionservice.data.soap.dto.model.ContainerTransactionIonDto

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = arrayOf(""))
@XmlRootElement(namespace = ContainerEndpoint.NAMESPACE_URI, name = "GetContainerResponse")
class GetContainerResponse {
    @XmlElement(required = true, namespace = ContainerEndpoint.NAMESPACE_URI)
    protected var containerResp: ContainerTransactionIonDto? = null
    fun getContainer(findUnit4Transfer: ContainerTransactionIonDto?): ContainerTransactionIonDto? {
        return containerResp
    }

    fun setContainer(value: ContainerTransactionIonDto?) {
        containerResp = value
        println("response to client ${containerResp}")
    }
}