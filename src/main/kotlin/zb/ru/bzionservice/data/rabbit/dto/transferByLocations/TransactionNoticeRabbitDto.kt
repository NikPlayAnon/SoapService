package zb.ru.bzionservice.data.rabbit.dto.transferByLocations

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import zb.ru.bzionservice.data.rabbit.dto.IonError.AbortReason

@JsonIgnoreProperties(ignoreUnknown = true)
data class TransactionNoticeRabbitDto(
        @JsonAlias("transaction_id")
        val transaction_id: String,
        @JsonAlias("success")
        val transaction_status: Boolean,
        @JsonAlias("datentime")
        val transaction_date: String,
        @JsonAlias("tenantId")
        val tenantId: String,
        @JsonAlias("errorLog")
        val abort_reason: List<String>?
) {
}
fun TransactionNoticeRabbitDto.toRabbitUpdate(): TransactionNoticeOneItemRabbitDto {
        var abort_reason_desirealised: AbortReason? = null

        if (abort_reason!!.size>0){
                abort_reason_desirealised = jacksonObjectMapper().readValue(content = abort_reason?.first() ?: "{}")
        }


        return TransactionNoticeOneItemRabbitDto(
                transaction_id = transaction_id,
                transaction_date = transaction_date,
                transaction_status = if(transaction_status) "COMPLETED" else "FAILED",
                user = tenantId,
                abort_reason =  abort_reason_desirealised
        )
}