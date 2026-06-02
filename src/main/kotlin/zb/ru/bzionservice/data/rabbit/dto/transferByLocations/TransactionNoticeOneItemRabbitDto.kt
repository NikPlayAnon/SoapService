package zb.ru.bzionservice.data.rabbit.dto.transferByLocations

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import zb.ru.bzionservice.data.rabbit.dto.IonError.AbortReason

@JsonIgnoreProperties(ignoreUnknown = true)
data class TransactionNoticeOneItemRabbitDto(
        @JsonProperty("transaction_id")
        @JsonAlias("transaction_id")
        val transaction_id: String,
        @JsonProperty("transaction_status")
        @JsonAlias("success")
        val transaction_status: String,
        @JsonProperty("transaction_date")
        @JsonAlias("datentime")
        val transaction_date: String,
        @JsonProperty("transaction_user_login")
        @JsonAlias("user")
        val user: String,
        @JsonProperty("abort_reason")
        @JsonAlias("abort_reason")
        val abort_reason: AbortReason?
) {
}