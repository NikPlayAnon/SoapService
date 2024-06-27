package zb.ru.bzionservice.rabbit.dto.IonError

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

data class MeasuredRemainder(
        @JsonAlias("id")
        val id: String,
        @JsonAlias("abort_reason")
        val abortReason: AbortReason
) {}