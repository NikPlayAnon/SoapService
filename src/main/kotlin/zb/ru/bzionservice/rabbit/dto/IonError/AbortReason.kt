package zb.ru.bzionservice.rabbit.dto.IonError

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class AbortReason(
        @JsonAlias("errors")
        val errors: Errors?,
        @JsonAlias("general")
        val general: Error?) {
}