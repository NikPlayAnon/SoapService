package zb.ru.bzionservice.data.soap.transfer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload
import zb.ru.bzionservice.data.soap.dto.to_dto.TransferItemsIonMapper
import zb.ru.bzionservice.data.soap.handling.request.GetTransferRequest
import zb.ru.bzionservice.data.soap.handling.response.GetTransferResponse
import zb.ru.bzionservice.data.soap.transfer.request.SetTransferAcknowledgeRequest
import zb.ru.bzionservice.data.soap.transfer.response.SetTransferAcknowledgeResponse
import zb.ru.bzionservice.soap.dto.to_dto.TransactionNoticeMapper
import zb.ru.bzionservice.usecases.transfer.TransferServiceImpl

@Endpoint
class TransferEndpoint @Autowired constructor(transferService: TransferServiceImpl) {
    companion object{
        const val NAMESPACE_URI: String = "http://spring.io/guides/gs-producing-web-service"
    }

    private var transferService: TransferServiceImpl? = null

    @Autowired
    fun AdvancedEndpoint(transferService: TransferServiceImpl?) {
        this.transferService = transferService
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetTransferRequest")
    @ResponsePayload
    fun getTransferItems(@RequestPayload request: GetTransferRequest): GetTransferResponse? {
        val response = GetTransferResponse()
//        response.setHandlingUnits(TransferItemsIonMapper().transform(handlingUnitsService?.findFirstUnit()))
        response.setTransferItems(TransferItemsIonMapper().transform(transferService?.findFirstUnit()))
        return response
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SetTransferAcknowledgeRequest")
    @ResponsePayload
    fun setTransferAcknowledge(@RequestPayload request: SetTransferAcknowledgeRequest): SetTransferAcknowledgeResponse? {
        transferService?.setResponse(TransactionNoticeMapper().transform(request.getMvidReq()))
        val response = SetTransferAcknowledgeResponse()
        response.setAcknowledge(response.getAcknowledge())
        return response
    }
}
