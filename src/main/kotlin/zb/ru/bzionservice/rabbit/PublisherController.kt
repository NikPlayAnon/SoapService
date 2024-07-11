package zb.ru.bzionservice.rabbit

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import zb.ru.bzionservice.rabbit.dto.IonNotice


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
    @Value("\${response_measured-remainder.key}")
    private val routingKey: String? = null


    @RequestMapping("/emit")
    @ResponseBody
    fun queue1(message: IonNotice): String? {
        println("mess " + message)
//        val mapper = ObjectMapper().registerModule(KotlinModule())
//        val mapper = ObjectMapper()
//        println("returning " + mapper.writeValueAsString(message))
//        rabbitTemplate.convertAndSend(this.exchange!!,this.routingKey!!, mapper.writeValueAsString(message))
        rabbitTemplate.convertAndSend(this.exchange!!,this.routingKey!!, message)
        return "Emit to queue"

    }
}
