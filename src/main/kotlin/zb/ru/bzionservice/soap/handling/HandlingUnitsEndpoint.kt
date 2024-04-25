package zb.ru.bzionservice.soap.handling

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload
import zb.ru.bzionservice.service.handling.HandlingUnitServiceImpl
import zb.ru.bzionservice.soap.handling.request.GetHandlingUnitsRequest
import zb.ru.bzionservice.soap.handling.response.GetHandlingUnitsResponse


//private const val NAMESPACE_URI: String = "http://in28minutes.com/students"
@Endpoint
class HandlingUnitsEndpoint @Autowired constructor(handlingUnitsService: HandlingUnitServiceImpl) {
    companion object{
        const val NAMESPACE_URI: String = "http://spring.io/guides/gs-producing-web-service"
    }

    private var handlingUnitsService: HandlingUnitServiceImpl? = null

    @Autowired
    fun AdvancedEndpoint(handlingUnitsService: HandlingUnitServiceImpl?) {
        this.handlingUnitsService = handlingUnitsService
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetHandlingUnitsRequest")
    @ResponsePayload
//    fun getUnit4Transfer(@org.springframework.ws.server.endpoint.annotation.RequestPayload request: GetUnit4TransferRequest): GetUnit4TransferResponse? {
    fun getHandlingUnits(@RequestPayload request: GetHandlingUnitsRequest): GetHandlingUnitsResponse? {
        val response = GetHandlingUnitsResponse()
        response.setUnit4Transfer(handlingUnitsService?.findFirstUnit())
        return response
    }
}