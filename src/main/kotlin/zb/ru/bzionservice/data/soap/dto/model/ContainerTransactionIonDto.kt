package zb.ru.bzionservice.data.soap.dto.model

import jakarta.xml.bind.annotation.XmlElement
import zb.ru.bzionservice.data.soap.container.ContainerEndpoint

data class ContainerTransactionIonDto(
    @field:XmlElement(name="transactionId",namespace = ContainerEndpoint.NAMESPACE_URI)
    val transactionId: String,
    @field:XmlElement(name="transactionDate",namespace = ContainerEndpoint.NAMESPACE_URI)
    val transactionDate: String,
    @field:XmlElement(name="user",namespace = ContainerEndpoint.NAMESPACE_URI)
    val user: String,
    @field:XmlElement(name="container",namespace = ContainerEndpoint.NAMESPACE_URI)
    val container: ContainerIonDto) {
}