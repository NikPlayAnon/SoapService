package zb.ru.bzionservice.data.rabbit.dto.container

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

data class ContainerTransactionRabbitDto(
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
    @JsonAlias("user")
    val user: String,
    @JsonProperty("placement_container")
    @JsonIgnore
    val container: ContainerNoticeRabbitDto
)
