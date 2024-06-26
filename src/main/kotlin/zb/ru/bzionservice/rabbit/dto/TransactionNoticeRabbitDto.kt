package zb.ru.bzionservice.rabbit.dto

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class TransactionNoticeRabbitDto(
        @JsonAlias("transactionId")
        val transactionId: String,
        @JsonAlias("success")
        val success: Boolean,
        @JsonAlias("datentime")
        val datentime: String,
        @JsonAlias("errorLog")
        val errorLog: List<String>?
) {
}