package zb.ru.bzionservice.data.rabbit.dto.container.wrapper

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import zb.ru.bzionservice.data.rabbit.dto.container.ContainerTransactionNoticeRabbitDto
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

data class TransactionWrapperTo(
    @JsonProperty("message_id")
    @JsonAlias("message_id")
    val messageId: String = UUID.randomUUID().toString(),
    @JsonProperty("date")
    @JsonAlias("date")
    val data: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSS")),
    @JsonProperty("type")
    @JsonAlias("type")
    val type: String,
    @JsonProperty("transaction")
    @JsonAlias("transaction")
    val transaction: ContainerTransactionNoticeRabbitDto
)
