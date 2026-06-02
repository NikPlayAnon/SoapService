package zb.ru.bzionservice.data.rabbit.dto.IonError

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class AbortReason(
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("errors")
        @JsonAlias("errors")
        val errors: Errors?,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("general")
        @JsonAlias("general")
        val general: Error?) {
}