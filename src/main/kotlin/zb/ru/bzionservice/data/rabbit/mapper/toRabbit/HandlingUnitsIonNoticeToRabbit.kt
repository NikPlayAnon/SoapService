package zb.ru.bzionservice.data.rabbit.mapper.toRabbit

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import zb.ru.bzionservice.model.TransactionNotice
import zb.ru.bzionservice.data.rabbit.dto.IonNotice
import zb.ru.bzionservice.data.soap.dto.Mapper

class HandlingUnitsIonNoticeToRabbit: Mapper<TransactionNotice, IonNotice> {
    override fun transform(source: TransactionNotice?): IonNotice {

        var errorstring: String =""
        source?.errorLog?.forEach { errorstring+= it }
//        println("errorstring =" + errorstring)
        if (!errorstring.isNullOrEmpty()) {
            val ionNotice: IonNotice = jacksonObjectMapper().readValue(content = errorstring)
            ionNotice?.transaction_id=source!!.transactionId
            ionNotice?.transaction_date=source.datentime
            ionNotice?.transaction_status="FAILED"
            ionNotice?.user=source.tenantId
            return ionNotice
        } else {
            return IonNotice(
                    source!!.transactionId,
                    source.datentime,
                    "COMPLETED",
                    source.tenantId,
                    null
            )
        }
    }
}
