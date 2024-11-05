package zb.ru.bzionservice.data.rabbit.dto.IonError

import com.fasterxml.jackson.annotation.JsonAlias

data class Error(
        @JsonAlias("code")
        val code: String,
        @JsonAlias("description")
        val description: String
) {
}