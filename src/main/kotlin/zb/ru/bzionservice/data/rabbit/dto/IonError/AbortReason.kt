package zb.ru.bzionservice.data.rabbit.dto.IonError

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
data class AbortReason(
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonAlias("errors")
        val errors: Errors?,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonAlias("general")
        val general: Error?) {
}