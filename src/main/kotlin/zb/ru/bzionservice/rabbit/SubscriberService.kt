package zb.ru.bzionservice.rabbit

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import zb.ru.bzionservice.rabbit.dto.HandlingUnitsRabbitDto
import zb.ru.bzionservice.rabbit.mapper.fromRabbit.HandlingUnitsFromRabbitMapper
import zb.ru.bzionservice.repository.HandlingUnitRepositoryImpl
import java.util.concurrent.CountDownLatch


//@Log4j2
@Component
class SubscriberService (
    val objectMapper: ObjectMapper,
    var repositoryImpl: HandlingUnitRepositoryImpl
) {



    @RabbitListener(queues = ["\${spring.rabbitmq.queue.to.bzionservice}"]) // Dynamically reading the queue name using SpEL from the "queue" object.
    fun receive(message: String) =
        repositoryImpl.addToQueue(HandlingUnitsFromRabbitMapper().transform(objectMapper.readValue<HandlingUnitsRabbitDto>(message)))
}

