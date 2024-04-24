package zb.ru.bzionservice.soap.endpoint.request

import jakarta.xml.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.repository.HandlingUnitRepositoryImpl
import zb.ru.bzionservice.service.handling.HandlingUnitService
import zb.ru.bzionservice.service.handling.HandlingUnitServiceImpl
import zb.ru.bzionservice.soap.endpoint.HandlingUnitsEndpoint

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["fromIon"])
@XmlRootElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, name = "GetHandlingUnitsRequest")
class GetHandlingUnitsRequest {
    @XmlElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, required = true)
    protected var fromIon: String = "mark1"


    private val handlingUnit: HandlingUnitServiceImpl? = null

    fun GetRequestFromIon(): HandlingUnits? {
        println(fromIon) //asd
        return handlingUnit?.findFirstUnit()
    }
}