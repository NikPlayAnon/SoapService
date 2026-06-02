package zb.ru.bzionservice.data.soap.container

import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload
import zb.ru.bzionservice.data.soap.container.request.GetContainerRequest
import zb.ru.bzionservice.data.soap.container.request.SetContainerAcknowledgeRequest
import zb.ru.bzionservice.data.soap.container.response.GetContainerResponse
import zb.ru.bzionservice.data.soap.container.response.SetContainerAcknowledgeResponse
import zb.ru.bzionservice.data.soap.dto.from_dto.ContainerTransactionMapper
import zb.ru.bzionservice.data.soap.dto.to_dto.ContainerTransactionIonMapper
import zb.ru.bzionservice.model.ContainerTransactionNotice
import zb.ru.bzionservice.usecases.container.ContainerTransactionService
import zb.ru.bzionservice.usecases.container.ContainerTransactionServiceImpl


@Endpoint
class ContainerEndpoint(val service: ContainerTransactionServiceImpl) {
    companion object{
        const val NAMESPACE_URI: String = "http://spring.io/guides/gs-producing-web-service"
    }

    @PayloadRoot(namespace = ContainerEndpoint.NAMESPACE_URI, localPart = "GetContainerRequest")
    @ResponsePayload
    fun getContainer(@RequestPayload request: GetContainerRequest): GetContainerResponse? {
        val response = GetContainerResponse()
        response.setContainer(ContainerTransactionIonMapper().transform(service.findFirstUnit()))
        return response
    }

    @PayloadRoot(namespace = ContainerEndpoint.NAMESPACE_URI, localPart = "SetContainerAcknowledgeRequest")
    @ResponsePayload
    fun setContainerAcknowledgeRequest(@RequestPayload request: SetContainerAcknowledgeRequest): SetContainerAcknowledgeResponse? {
        service.setResponse(ContainerTransactionMapper().transform(request.setContainer()))
        val response = SetContainerAcknowledgeResponse()
        response.setContainer(response.getContainer())
        return response
    }
}