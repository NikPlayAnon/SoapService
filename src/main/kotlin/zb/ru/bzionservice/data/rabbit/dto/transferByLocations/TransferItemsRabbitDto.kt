package zb.ru.bzionservice.data.rabbit.dto.transferByLocations

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class TransferItemsRabbitDto(
        @JsonProperty("transaction_id")
        @JsonAlias("id", "transaction_id")
        val transaction_id: String,
        @JsonProperty("transaction_date")
        @JsonAlias("transaction_date")
        val transaction_date: String,
        val actionCode: String = "transferItems",
        @JsonProperty("transaction_status")
        @JsonAlias("status", "transaction_status")
        val transaction_status: String?,
        @JsonProperty("transaction_user_login")
        @JsonAlias("transaction_user_login", "user")
        val user_login: String?,
        @JsonProperty("transfer")
        @JsonAlias("transfer")
//        val transferItemList: List<TransferItemRabbitDto>?
        val transferItemList: TransferItemRabbitDto?
) {
}