package zb.ru.bzionservice.soap.endpoint.response

import jakarta.xml.bind.annotation.*
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload
import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.soap.endpoint.HandlingUnitsEndpoint

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["handlingUnitsResp"])
@XmlRootElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, name = "GetHandlingUnitsResponse")
class GetHandlingUnitsResponse {
    @XmlElement(required = true, namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    protected var handlingUnitsResp: HandlingUnits? = null

    fun setHandlingUnits(value: HandlingUnits?) {
        handlingUnitsResp = value
    }
}