package zb.ru.bzionservice.data.soap.transfer.request

import jakarta.xml.bind.annotation.*
import zb.ru.bzionservice.data.soap.dto.model.TransactionNoticeIonDto
import zb.ru.bzionservice.data.soap.handling.HandlingUnitsEndpoint
import zb.ru.bzionservice.data.soap.transfer.TransferEndpoint


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["mvid", "success", "datentime", "actionCodeField", "tenantId", "errorlog"])
@XmlRootElement(namespace = TransferEndpoint.NAMESPACE_URI, name = "SetTransferAcknowledgeRequest")
class SetTransferAcknowledgeRequest {
    @XmlElement(namespace = TransferEndpoint.NAMESPACE_URI, required = true)
    protected var mvid: String = "null"
    @XmlElement(namespace = TransferEndpoint.NAMESPACE_URI, required = true)
    protected var success: String = "null"
    @XmlElement(namespace = TransferEndpoint.NAMESPACE_URI, required = true)
    protected var datentime: String = "null"
    @XmlElement(namespace = TransferEndpoint.NAMESPACE_URI, required = true)
    protected var actionCodeField: String = "null"
    @XmlElement(namespace = TransferEndpoint.NAMESPACE_URI, required = true)
    protected var tenantId: String = "null"
    @XmlElementWrapper(namespace = TransferEndpoint.NAMESPACE_URI, name = "errorlog")
    @XmlElement(namespace = TransferEndpoint.NAMESPACE_URI, name = "error")
    private var errorlog: MutableList<String>? = null



    fun getMvidReq(): TransactionNoticeIonDto {
//        println("\n errorlog>>>> "+errorlog.toString())
        //TODO: this is tmp only
        this.actionCodeField="TransferItemByBinTransactionMessage"

        if (this.success!="Accepted") {
            val errorIon: String = errorlog?.first() ?: ""
            val erroruonType: String = when(errorIon.split(";")[0]) {
                "2001" -> "warehouse"
                "2002" -> "location_source"
                "2003" -> "location_target"
                "2004" -> "item"
                "2005" -> "quantity"
                else -> "general"
            }
            //TODO: fix this mess vvv
            val generalerror: String
            if (erroruonType == "general"){
                generalerror =
                    """{"$erroruonType": {"code": "${errorIon.split(";")[0]}","description": "${
                        errorIon.split(";")[1]
                    }"}}"""
            } else{
                generalerror =
                    """{"errors": {"$erroruonType": {"code": "${errorIon.split(";")[0]}","description": "${
                        errorIon.split(";")[1]
                    }"}}}"""
            }


            return TransactionNoticeIonDto(mvid=this.mvid, success=this.success=="Accepted", datentime=this.datentime, actionCodeField=this.actionCodeField, tenantId=this.tenantId, errorlog= listOf(generalerror))
        }

        return TransactionNoticeIonDto(mvid=this.mvid, success=this.success=="Accepted", datentime=this.datentime, actionCodeField=this.actionCodeField, tenantId=this.tenantId, errorlog=errorlog)
    }


}