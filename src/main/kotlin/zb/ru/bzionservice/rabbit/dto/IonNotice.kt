package zb.ru.bzionservice.rabbit.dto

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import zb.ru.bzionservice.rabbit.dto.IonError.MeasuredRemainder

@JsonIgnoreProperties(ignoreUnknown = true)
data class IonNotice(
        @JsonAlias("transactionid")
        var transactionid: String,
        @JsonAlias("transactiondate")
        var transactiondate: String,
        @JsonAlias("transactionstatus")
        var transactionstatus: String,
        @JsonAlias("user")
        var user: String,
        @JsonAlias("measured_remainders")
        val measuredRemainders: List<MeasuredRemainder>
) {}