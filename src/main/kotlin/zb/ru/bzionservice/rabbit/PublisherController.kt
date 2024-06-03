package zb.ru.bzionservice.rabbit

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import zb.ru.bzionservice.rabbit.dto.TransactionNoticeRabbitDto
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.beans.factory.annotation.Value


//@Log4j2


@Component
//class PublisherController(private val amqpTemplate: AmqpTemplate) {
    class PublisherController(private val rabbitTemplate: RabbitTemplate) {

//    @Autowired
//    var template: AmqpTemplate? = null
//    var template: AmqpTemplate? = AmqpTemplate()

    @Value("\${spring.rabbitmq.exchange}")
    private val exchange: String? = null

    // Value is populated with the routing key from "application.properties" file.
    @Value("\${spring.rabbitmq.routingkey.setter}")
    private val routingKey: String? = null


    @RequestMapping("/emit")
    @ResponseBody
    fun queue1(message: TransactionNoticeRabbitDto): String? {

        val mapper = ObjectMapper().registerModule(KotlinModule())
        rabbitTemplate.convertAndSend(this.exchange!!,this.routingKey!!, mapper.writeValueAsString(message))
        return "Emit to queue"
    }
}


//@RestController
////@Controller
//@RequestMapping("/springrabbitmqapi")
//class PublisherController
//    (
//    val rabbitTemplate: RabbitTemplate = RabbitTemplate(),
//    val binding: Binding
//) {
////    @Autowired
////    private var rabbitTemplate: RabbitTemplate = RabbitTemplate()
////    @Autowired
////    private lateinit var binding: Binding
//
//
//    @PostMapping(value = ["/send"])
//    @ResponseStatus(code = HttpStatus.OK)
//    fun send(@RequestBody message: String?): String {
//        println("Sending message to the queue...")
////        log.info("Sending message to the queue...")
//
//        rabbitTemplate.convertAndSend( binding.exchange, binding.routingKey, message!!)
//        println("Message sent successfully to the queue, sending back the response to the user...")
////        log.info("Message sent successfully to the queue, sending back the response to the user...")
//        return "Message sent successfully to the queue!"
//    }
//}
