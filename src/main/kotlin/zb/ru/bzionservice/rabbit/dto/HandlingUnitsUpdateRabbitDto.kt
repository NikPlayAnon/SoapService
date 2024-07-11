package zb.ru.bzionservice.rabbit.dto

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class HandlingUnitsUpdateRabbitDto(
        @JsonAlias("id")
        val transaction_id: String,
        @JsonAlias("transaction_date")
        val transaction_date: String,
        val actionCode: String = "inventoryManagement",
        @JsonAlias("status")
        val transaction_status: String?,
        @JsonAlias("userLogin")
        val user: String?,
        @JsonAlias("measured_remainders", "measuredRemainder")
        val measured_remainder: HandlingUnitRabbitDto?
) {
}