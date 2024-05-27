package zb.ru.bzionservice.rabbit

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json
import org.springframework.stereotype.Service
import zb.ru.bzionservice.rabbit.dto.HandlingUnitsRabbitDto
import zb.ru.bzionservice.rabbit.mapper.fromRabbit.HandlingUnitsFromRabbitMapper
import zb.ru.bzionservice.repository.HandlingUnitRepositoryImpl


//@Log4j2
@Service
class SubscriberService {
    @Autowired
    private lateinit var objectMapper: ObjectMapper
    @Autowired
    private lateinit var repositoryImpl: HandlingUnitRepositoryImpl

    @Autowired
    private val queue: Queue? = null
    @RabbitListener(queues = ["#{queue.getName()}"]) // Dynamically reading the queue name using SpEL from the "queue" object.
    fun receive(message: String) {
        println("Listening messages from the queue!!")
        println("Received the following message from the queue= $message")
        println("Message received successfully from the queue.")

        var handlingUnitsRabbitDto: HandlingUnitsRabbitDto = objectMapper.readValue<HandlingUnitsRabbitDto>(message);
        repositoryImpl.addToQueue(HandlingUnitsFromRabbitMapper().transform(handlingUnitsRabbitDto))
//        log.info("Listening messages from the queue!!")
//        log.info("Received the following message from the queue= $message")
//        log.info("Message received successfully from the queue.")
    }
}

