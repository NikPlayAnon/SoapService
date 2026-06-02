package zb.ru.bzionservice.data.soap.container.request

import jakarta.xml.bind.annotation.*
import zb.ru.bzionservice.data.soap.handling.HandlingUnitsEndpoint

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["transferReq"])
@XmlRootElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, name = "GetContainerRequest")
class GetContainerRequest {
    @XmlElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, required = true)
    protected var transferReq: String = "testmark"
    fun getMvidReq(): String {
        println("fromIon="+ transferReq)
        return transferReq
    }

    fun setMvidReq(value: String) {
        println("fromIon="+ transferReq)
        transferReq = value
    }
}