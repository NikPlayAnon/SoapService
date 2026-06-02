package zb.ru.bzionservice.data.rabbit

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import zb.ru.bzionservice.data.rabbit.dto.HandlingUnitsRabbitDto
import zb.ru.bzionservice.data.rabbit.dto.HandlingUnitsUpdateRabbitDto
import zb.ru.bzionservice.data.rabbit.dto.container.wrapper.TransactionWrapperFrom
import zb.ru.bzionservice.data.rabbit.dto.transferByLocations.TransferItemsRabbitDto
import zb.ru.bzionservice.data.rabbit.dto.transferByLocations.wrapper.TransferTransactionWrapperFrom
import zb.ru.bzionservice.data.rabbit.mapper.fromRabbit.HandlingUnitsFromRabbitMapper
import zb.ru.bzionservice.data.rabbit.mapper.fromRabbit.HandlingUnitsFromRabbitMapperUpdate
import zb.ru.bzionservice.data.rabbit.mapper.fromRabbit.TransferItemsFromRabbitMapper
import zb.ru.bzionservice.data.rabbit.mapper.fromRabbit.container.ContainerTransactionFromRabbit
import zb.ru.bzionservice.data.repository.ContainerTransactionRepositoryImpl
import zb.ru.bzionservice.data.repository.HandlingUnitRepositoryImpl
import zb.ru.bzionservice.data.repository.TransferRepositoryImpl


//@Log4j2
@Component
class SubscriberService (
    val objectMapper: ObjectMapper,
    var repositoryImpl: HandlingUnitRepositoryImpl,
    var transferRepositoryImpl: TransferRepositoryImpl,
    val containerRepositoryImpl: ContainerTransactionRepositoryImpl
) {



    @RabbitListener(queues = ["\${inventory_measured-remainders}"]) // Dynamically reading the queue name using SpEL from the "queue" object. // Dynamically reading the queue name using SpEL from the "queue" object.
    fun receive(message: HandlingUnitsRabbitDto) {
        println("Read from the queue = " + HandlingUnitsFromRabbitMapper().transform(message))
        repositoryImpl.addToQueue(HandlingUnitsFromRabbitMapper().transform(message))
    }

    @RabbitListener(queues = ["\${update_measured-remainder}"]) // Dynamically reading the queue name using SpEL from the "queue" object. // Dynamically reading the queue name using SpEL from the "queue" object.
    fun receiveUpdate(message: HandlingUnitsUpdateRabbitDto) {
        println("Read from the queue = " + HandlingUnitsFromRabbitMapperUpdate().transform(message))
        repositoryImpl.addToQueue(HandlingUnitsFromRabbitMapperUpdate().transform(message))
    }

    @RabbitListener(queues = ["\${transfer_transfer_by_locations}"]) // Dynamically reading the queue name using SpEL from the "queue" object. // Dynamically reading the queue name using SpEL from the "queue" object.
    fun receiveTransfer(message: TransferTransactionWrapperFrom) {
//        println("mess = " + TransferItemsFromRabbitMapper().transform(message))
        transferRepositoryImpl.addToQueue(TransferItemsFromRabbitMapper().transform(message.transaction))
    }

    @RabbitListener(queues = ["\${PlacementContainerMessageListener}"]) // Dynamically reading the queue name using SpEL from the "queue" object. // Dynamically reading the queue name using SpEL from the "queue" object.
    fun receiveContainer(message: TransactionWrapperFrom) {
        containerRepositoryImpl.addToQueue(ContainerTransactionFromRabbit().transform(
            message.transaction
        ))
//        println(
//            message.transaction
//        )
//        val a: ContainerTransactionNoticeRabbitDto = jacksonObjectMapper().readValue(message.transaction.toString())
//        println(message.transaction)

    }

}

