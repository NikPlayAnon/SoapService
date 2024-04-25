package zb.ru.bzionservice.soap.handling.response

import jakarta.xml.bind.annotation.*
import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.soap.handling.HandlingUnitsEndpoint

@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "", propOrder = ["unit4Transfer"])
@XmlType(name = "", propOrder = arrayOf(""))
@XmlRootElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, name = "GetHandlingUnitsResponse")
class GetHandlingUnitsResponse {
    @XmlElement(required = true, namespace = HandlingUnitsEndpoint.NAMESPACE_URI)
    protected var handlingUnitsResp: HandlingUnits? = null
    fun getUnit4Transfer(findUnit4Transfer: HandlingUnits?): HandlingUnits? {
        return handlingUnitsResp
    }

    fun setUnit4Transfer(value: HandlingUnits?) {
        handlingUnitsResp = value
    }
}
