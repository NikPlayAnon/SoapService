package zb.ru.bzionservice.rabbit.mapper.toRabbit

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import zb.ru.bzionservice.model.TransactionNotice
import zb.ru.bzionservice.rabbit.dto.IonNotice
import zb.ru.bzionservice.rabbit.dto.TransactionNoticeRabbitDto
import zb.ru.bzionservice.soap.dto.Mapper

class IonNoticeToRabbit: Mapper<TransactionNotice, IonNotice> {
    override fun transform(source: TransactionNotice?): IonNotice {

        var errorstring: String =""
        source?.errorLog?.forEach { errorstring+= it }
        println("errorstring= "+errorstring)
        if (!errorstring.isNullOrEmpty()) {
            val ionNotice: IonNotice = jacksonObjectMapper().readValue(content = errorstring)
            ionNotice?.transactionid=source!!.transactionId
            ionNotice?.transactiondate=source!!.datentime
            return ionNotice
        } else {
            return IonNotice(
                    source!!.transactionId,
                    source.datentime,
                    "success",
                    "someone",
//                    listOf()
                    null
            )
        }
    }

}

//
//var errorstring: String =""
//response.errorLog?.forEach { errorstring+= it }
//println("errorstring= "+errorstring)
//if (!errorstring.isNullOrEmpty()) {
//    val ionNotice: IonNotice? = jacksonObjectMapper()?.readValue(content = errorstring)
//    println("ionNotice="+ ionNotice)
//}