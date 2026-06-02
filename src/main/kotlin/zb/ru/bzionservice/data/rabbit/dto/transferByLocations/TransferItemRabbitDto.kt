package zb.ru.bzionservice.data.rabbit.dto.transferByLocations

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class TransferItemRabbitDto(
        @JsonProperty("warehouse_code")
        @JsonAlias("warehouse_code")
        val warehouse: String,
        @JsonProperty("location_source")
        @JsonAlias("location_source")
        val locationSource: String,
        @JsonProperty("location_target")
        @JsonAlias("location_target")
        val locationTarget: String,
        @JsonProperty("item_code")
        @JsonAlias("item_code")
        val item: String ="",
        @JsonProperty("lot_code")
        @JsonAlias("lot_code")
        val lot: String ="",
        @JsonProperty("quantity")
        @JsonAlias("quantity")
        val quantity: Float
        ) {
}