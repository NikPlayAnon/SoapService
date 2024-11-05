package zb.ru.bzionservice.data.soap.handling.response

import jakarta.xml.bind.annotation.*
import zb.ru.bzionservice.data.soap.dto.model.HandlingUnitsIonDto
import zb.ru.bzionservice.data.soap.handling.HandlingUnitsEndpoint

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = arrayOf(""))
@XmlRootElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, name = "GetHandlingUnitsResponse")
class GetHandlingUnitsResponse {
    @XmlElement(required = true, namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    protected var handlingUnitsResp: HandlingUnitsIonDto? = null
    fun getHandlingUnits(findUnit4Transfer: HandlingUnitsIonDto?): HandlingUnitsIonDto? {
        return handlingUnitsResp
    }

    fun setHandlingUnits(value: HandlingUnitsIonDto?) {
        handlingUnitsResp = value
    }
}
