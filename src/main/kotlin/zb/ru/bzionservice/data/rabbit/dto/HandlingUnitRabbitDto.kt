package zb.ru.bzionservice.data.rabbit.dto

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

/*
"id": "R202011040000000009",    +
    "remainder": "F5400603-1",
    "project": "057090",
    "material": "РСА36",
    "warehouse": "",            +
    "location": "",             +
    "sequence": 0,              +
    "status": 1,                +
    "comment": "dsf",           +
    "length": 2600,             +
    "width": 500,               +
    "depth": 0
 */