package zb.ru.bzionservice.data.rabbit.dto

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import zb.ru.bzionservice.data.rabbit.dto.IonError.MeasuredRemainder

@JsonIgnoreProperties(ignoreUnknown = true)
data class IonUpdateNotice(
        @JsonAlias("transactionid")
        var transaction_id: String,
        @JsonAlias("transactiondate")
        var transaction_date: String,
        @JsonAlias("transactionstatus")
        var transaction_status: String,
        @JsonAlias("user")
        var user: String,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonAlias("measured_remainder")
        val measured_remainder: MeasuredRemainder?
) {}

fun IonNotice.toRabbitUpdate(): IonUpdateNotice =
        IonUpdateNotice(
                transaction_id = transaction_id,
                transaction_date = transaction_date,
                transaction_status = transaction_status,
                user = user,
                measured_remainder = measured_remainders?.first()
        )