package zb.ru.bzionservice.rabbit

import org.springframework.amqp.core.Binding
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import zb.ru.bzionservice.repository.HandlingUnitRepositoryImpl


//@Log4j2
@RestController
@RequestMapping("/springrabbitmqapi")
class PublisherController {
    @Autowired
    private lateinit var rabbitTemplate: RabbitTemplate
    @Autowired
    private lateinit var binding: Binding
    @PostMapping(value = ["/send"])
    @ResponseStatus(code = HttpStatus.OK)
    fun send(@RequestBody message: String?): String {
        println("Sending message to the queue...")
//        log.info("Sending message to the queue...")
        rabbitTemplate.convertAndSend(binding.exchange, binding.routingKey, message!!)
        println("Message sent successfully to the queue, sending back the response to the user...")
//        log.info("Message sent successfully to the queue, sending back the response to the user...")
        return "Message sent successfully to the queue!"
    }
}
