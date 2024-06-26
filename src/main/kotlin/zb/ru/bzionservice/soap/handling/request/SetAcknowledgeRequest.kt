package zb.ru.bzionservice.soap.handling.request

import jakarta.xml.bind.annotation.*
import zb.ru.bzionservice.soap.dto.model.TransactionNoticeIonDto
import zb.ru.bzionservice.soap.handling.HandlingUnitsEndpoint


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["mvid", "success", "datentime", "errorlog"])
@XmlRootElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, name = "SetAcknowledgeRequest")
class SetAcknowledgeRequest {
    @XmlElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, required = true)
    protected var mvid: String = "null"
    @XmlElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, required = true)
    protected var success: String = "null"
    @XmlElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, required = true)
    protected var datentime: String = "null"
    @XmlElementWrapper(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, name = "errorlog")
    @XmlElement(namespace = HandlingUnitsEndpoint.NAMESPACE_URI, name = "error")
    private var errorlog: MutableList<String>? = null



    fun getMvidReq(): TransactionNoticeIonDto {
        return TransactionNoticeIonDto(mvid=this.mvid, success=this.success=="Accepted", datentime=this.datentime, errorlog=this.errorlog)
    }


}