package zb.ru.bzionservice.data.rabbit.dto.container

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import zb.ru.bzionservice.data.rabbit.dto.IonError.AbortReason

data class ContainerNoticeRabbitDto(
    @JsonProperty("container_code")
    @JsonAlias("container_code")
    val code: String,
    @JsonProperty("warehouse_code")
    @JsonAlias("warehouse_code")
    val warehouseCode: String?,
    @JsonProperty("bin_code")
    @JsonAlias("bin_code")
    var binCode: String,
    @JsonProperty("abort_reason")
    @JsonAlias("abort_reason")
    val abort_reason: AbortReason?
)