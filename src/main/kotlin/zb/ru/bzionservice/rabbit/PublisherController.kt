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
class PublisherController(private val rabbitTemplate: RabbitTemplate) {

    @Value("#{\${queue.key.map}}")
    val myMap: Map<String, String> = mapOf()

    @Value("\${spring.rabbitmq.exchange}")
    private val exchange: String? = null

    @Value("\${response_measured-remainder.key}")
    private var routingKey: String? = null


    @RequestMapping("/emit")
    @ResponseBody
    fun queue1(message: IonNotice, action: String): String? {
//        val temp = "writeOffOfGoods.key"


//        println(myMap[action+".key"])

        println("mess " + message)
//        rabbitTemplate.convertAndSend(this.exchange!!,this.routingKey!!, message)
        rabbitTemplate.convertAndSend(this.exchange!!,myMap[action+".key"]!!, message)
        return "Emit to queue"
    }
}
