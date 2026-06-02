package zb.ru.bzionservice.data.rabbit.dto.IonError

import com.fasterxml.jackson.annotation.JsonAlias
data class MeasuredRemainder(
        @JsonAlias("id")
        val id: String,
        @JsonAlias("abort_reason")
        val abort_reason: AbortReason
) {}