package zb.ru.bzionservice.rabbit.dto.IonError

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Errors(
        @JsonAlias("id")
        val id: Error?,
        @JsonAlias("warehouse")
        val warehouse: Error?,
        @JsonAlias("location")
        val location: Error?,
        @JsonAlias("sequence")
        val sequence: Error?,
        @JsonAlias("length_from")
        val lengthFrom: Error?) {
}