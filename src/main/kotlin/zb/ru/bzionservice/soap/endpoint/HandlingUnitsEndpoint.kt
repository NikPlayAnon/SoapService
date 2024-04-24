package zb.ru.bzionservice.soap.endpoint

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload
import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.soap.endpoint.request.GetHandlingUnitsRequest
import zb.ru.bzionservice.soap.endpoint.response.GetHandlingUnitsResponse

@Endpoint
class HandlingUnitsEndpoint {
    companion object{
        const val NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service"
    }

    var handlingUnit: HandlingUnits? = null
    @Autowired
    fun HandlingUnitsEndpoint(){
        this.handlingUnit = handlingUnit
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetHandlingUnitsRequest")
    @ResponsePayload
    fun getHandlingUnits(@RequestPayload request: GetHandlingUnitsRequest): GetHandlingUnitsResponse? {
        val response = GetHandlingUnitsResponse()
        response.setHandlingUnits(request.GetRequestFromIon())
        return response
    }
}