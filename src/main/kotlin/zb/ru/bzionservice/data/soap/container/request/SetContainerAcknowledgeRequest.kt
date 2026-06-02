package zb.ru.bzionservice.data.soap.container.request

import jakarta.xml.bind.annotation.*
import zb.ru.bzionservice.data.soap.container.ContainerEndpoint
import zb.ru.bzionservice.data.soap.dto.model.ContainerIonDto
import zb.ru.bzionservice.data.soap.dto.model.ContainerNoticeIonDto
import zb.ru.bzionservice.data.soap.transfer.TransferEndpoint


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["transactionId", "transactionDate", "transactionStatus", "user", "container", "errorlog"])
@XmlRootElement(namespace = ContainerEndpoint.NAMESPACE_URI, name = "SetContainerAcknowledgeRequest")
class SetContainerAcknowledgeRequest {
    @XmlElement(namespace = ContainerEndpoint.NAMESPACE_URI, required = true)
    protected var transactionId: String = "null"
    @XmlElement(namespace = ContainerEndpoint.NAMESPACE_URI, required = true)
    protected var transactionDate: String = "null"
    @XmlElement(namespace = ContainerEndpoint.NAMESPACE_URI, required = true)
    protected var transactionStatus: String = "null"
    @XmlElement(namespace = ContainerEndpoint.NAMESPACE_URI, required = true)
    protected var user: String = "null"
    @XmlElement(namespace = ContainerEndpoint.NAMESPACE_URI, required = true)
    protected var container: ContainerIonDto = ContainerIonDto("","","","")
    @XmlElementWrapper(namespace = ContainerEndpoint.NAMESPACE_URI, name = "errorlog")
    @XmlElement(namespace = ContainerEndpoint.NAMESPACE_URI, name = "error")
    private var errorlog: MutableList<String>? = null

    fun setContainer(): ContainerNoticeIonDto = ContainerNoticeIonDto(
        transactionId = transactionId,
        transactionDate = transactionDate,
        transactionStatus = transactionStatus,
        user = user,
        container = ContainerIonDto(container.code, container.warehouseCode, container.binCode, errorlog?.joinToString(" "))
    )
}