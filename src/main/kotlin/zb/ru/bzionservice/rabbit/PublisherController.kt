package zb.ru.bzionservice.rabbit

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody


//@Log4j2


@Component
class PublisherController(private val amqpTemplate: AmqpTemplate) {

//    @Autowired
//    var template: AmqpTemplate? = null
//    var template: AmqpTemplate? = AmqpTemplate()


    @RequestMapping("/emit")
    @ResponseBody
    fun queue1(): String? {
//        logger.info("Emit to queue1")
        amqpTemplate.convertAndSend("amq.direct","amq.direct.2", "Message to queue")
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
