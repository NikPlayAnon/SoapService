package zb.ru.bzionservice.soap.handling.request

import jakarta.xml.bind.annotation.*
import zb.ru.bzionservice.soap.handling.HandlingUnitsEndpoint

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["fromIon"])
@XmlRootElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, name = "GetHandlingUnitsRequest")
class GetHandlingUnitsRequest {
    @XmlElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, required = true)
    protected var fromIon: String = "testmark"
    fun getMvidReq(): String {
        println("fromIon="+ fromIon)
        return fromIon
    }

    fun setMvidReq(value: String) {
        println("fromIon="+ fromIon)
        fromIon = value
    }
}

