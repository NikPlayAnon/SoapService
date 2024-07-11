package zb.ru.bzionservice.rabbit.dto

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class HandlingUnitRabbitDto(
        @JsonAlias("id")
        val id: String,
        @JsonAlias("length")
        val length: Float?,
        @JsonAlias("width")
        val width: Float?,
        @JsonAlias("warehouse")
        val warehouse: String ="",
        @JsonAlias("location")
        val location: String ="",
        @JsonAlias("sequence")
        val sequence: Int,
        @JsonAlias("status")
        val status: Int,
        @JsonAlias("comment")
        val comment: String =""
        ) {
}