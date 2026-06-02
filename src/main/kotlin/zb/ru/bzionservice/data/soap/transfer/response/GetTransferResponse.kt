package zb.ru.bzionservice.data.soap.handling.response

import jakarta.xml.bind.annotation.*
import zb.ru.bzionservice.data.soap.dto.model.HandlingUnitsIonDto
import zb.ru.bzionservice.data.soap.dto.model.TransferItemsIonDto
import zb.ru.bzionservice.data.soap.handling.HandlingUnitsEndpoint
import zb.ru.bzionservice.data.soap.transfer.TransferEndpoint

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = arrayOf(""))
@XmlRootElement(namespace = TransferEndpoint.NAMESPACE_URI, name = "GetTransferResponse")
//@XmlRootElement(name = "GetHandlingUnitsResponse")
class GetTransferResponse {
    @XmlElement(required = true, namespace = TransferEndpoint.NAMESPACE_URI)
    protected var transferResp: TransferItemsIonDto? = null
    fun getTransferItems(findUnit4Transfer: TransferItemsIonDto?): TransferItemsIonDto? {
        return transferResp
    }

    fun setTransferItems(value: TransferItemsIonDto?) {
        transferResp = value
        println("response ${transferResp}")
    }
}
