package zb.ru.bzionservice.data.rabbit.dto.container

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import zb.ru.bzionservice.data.rabbit.dto.IonError.AbortReason
import zb.ru.bzionservice.model.Container

data class ContainerTransactionNoticeRabbitDto(
    @JsonProperty("transaction_id")
    @JsonAlias("transaction_id")
    val transactionId: Int,
    @JsonProperty("transaction_date")
    @JsonAlias("transaction_date")
    val transactionDate: String,
    @JsonProperty("transaction_status")
    @JsonAlias("transaction_status")
    val transactionStatus: String,
    @JsonProperty("transaction_user_login")
    @JsonAlias("transaction_user_login")
    val user: String,
    @JsonProperty("abort_reason")
    @JsonAlias("abort_reason")
    val abort_reason: AbortReason?
)