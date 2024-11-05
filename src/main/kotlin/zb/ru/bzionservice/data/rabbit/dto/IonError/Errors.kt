package zb.ru.bzionservice.data.rabbit.dto.IonError

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
data class Errors(
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonAlias("id")
        val id: Error?,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonAlias("warehouse")
        val warehouse: Error?,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonAlias("location")
        val location: Error?,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonAlias("sequence")
        val sequence: Error?,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonAlias("length")
        val length: Error?,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonAlias("width")
        val width: Error?,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonAlias("comment")
        val comment: Error?,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonAlias("status")
        val status: Error?
){
}