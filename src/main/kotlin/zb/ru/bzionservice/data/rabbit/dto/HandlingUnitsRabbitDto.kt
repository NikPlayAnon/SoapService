package zb.ru.bzionservice.data.rabbit.dto

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class HandlingUnitsRabbitDto(
        @JsonAlias("id", "transaction_id")
        val transaction_id: String,
        @JsonAlias("transaction_date")
        val transaction_date: String,
        val actionCode: String = "inventoryManagement",
        @JsonAlias("status", "transaction_status")
        val transaction_status: String?,
        @JsonAlias("userLogin", "user")
        val user: String?,
        @JsonAlias("measured_remainders", "measuredRemainder")
        val measured_remainder: List<HandlingUnitRabbitDto>?
) {
}