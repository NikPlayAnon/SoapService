package zb.ru.bzionservice.rabbit

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import zb.ru.bzionservice.rabbit.dto.HandlingUnitsRabbitDto
import zb.ru.bzionservice.rabbit.dto.HandlingUnitsUpdateRabbitDto
import zb.ru.bzionservice.rabbit.mapper.fromRabbit.HandlingUnitsFromRabbitMapper
import zb.ru.bzionservice.rabbit.mapper.fromRabbit.HandlingUnitsFromRabbitMapperUpdate
import zb.ru.bzionservice.repository.HandlingUnitRepositoryImpl


//@Log4j2
@Component
class SubscriberService (
    val objectMapper: ObjectMapper,
    var repositoryImpl: HandlingUnitRepositoryImpl
) {



    @RabbitListener(queues = ["\${inventory_measured-remainders}"]) // Dynamically reading the queue name using SpEL from the "queue" object. // Dynamically reading the queue name using SpEL from the "queue" object.
    fun receive(message: HandlingUnitsRabbitDto) {
        println("mess = " + HandlingUnitsFromRabbitMapper().transform(message))
        repositoryImpl.addToQueue(HandlingUnitsFromRabbitMapper().transform(message))
    }

    @RabbitListener(queues = ["\${update_measured-remainder}"]) // Dynamically reading the queue name using SpEL from the "queue" object. // Dynamically reading the queue name using SpEL from the "queue" object.
    fun receiveUpdate(message: HandlingUnitsUpdateRabbitDto) {
        println("mess = " + HandlingUnitsFromRabbitMapperUpdate().transform(message))
        repositoryImpl.addToQueue(HandlingUnitsFromRabbitMapperUpdate().transform(message))
    }
}

