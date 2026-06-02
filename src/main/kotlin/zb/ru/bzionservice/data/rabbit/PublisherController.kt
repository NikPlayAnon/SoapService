package zb.ru.bzionservice.data.rabbit

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import zb.ru.bzionservice.data.rabbit.dto.*
import zb.ru.bzionservice.data.rabbit.dto.container.ContainerTransactionNoticeRabbitDto
import zb.ru.bzionservice.data.rabbit.dto.container.wrapper.TransactionWrapperTo
import zb.ru.bzionservice.data.rabbit.dto.transferByLocations.TransactionNoticeOneItemRabbitDto
import zb.ru.bzionservice.data.rabbit.dto.transferByLocations.TransactionNoticeRabbitDto
import zb.ru.bzionservice.data.rabbit.dto.transferByLocations.toRabbitUpdate
import zb.ru.bzionservice.data.rabbit.dto.transferByLocations.wrapper.TransferTransactionWrapperTo


//@Log4j2


@Component
class PublisherController(private val rabbitTemplate: RabbitTemplate) {

    @Value("#{\${queue.key.map.return}}")
    val myMap: Map<String, String> = mapOf()

    @Value("\${spring.rabbitmq.exchange}")
    private val exchange: String? = null

    @Value("\${response_measured-remainder.key}")
    private var routingKey: String? = null

    @Value("\${spring.rabbitmp.transfer.exchange}")
    private val exchangeTransfer: String? = null


    @RequestMapping("/emit")
    @ResponseBody
    fun queue1(message: IonNotice, action: String): String? {
        println("writing to queue " + message)
        if (action=="inventoryManagement") { rabbitTemplate.convertAndSend(this.exchange!!,myMap[action+".key"]!!, message)}
        else {rabbitTemplate.convertAndSend(this.exchange!!,myMap[action+".key"]!!, message.toRabbitUpdate())}
//        rabbitTemplate.convertAndSend(this.exchange!!,myMap[action+".key"]!!, message)
        return "Emit to queue"
    }

    @RequestMapping("/emit")
    @ResponseBody
    fun queueTransfer(message: TransactionNoticeRabbitDto, action: String): String? {
        var messageRabbit: TransactionNoticeOneItemRabbitDto = message.toRabbitUpdate()
        rabbitTemplate.convertAndSend(myMap[action+".exchange"]!!,myMap[action+".key"]!!, TransferTransactionWrapperTo(type = action, transaction = messageRabbit))
        println("writing to queue " + jacksonObjectMapper().writeValueAsString(TransferTransactionWrapperTo(type = action, transaction = messageRabbit)))
        return "Emit to queue"
    }

    @RequestMapping("/emit")
    @ResponseBody
    fun queueContainer(message: ContainerTransactionNoticeRabbitDto, action: String): String? {
//        val formatter = SimpleDateFormat("yyyy-MM-dd")
//        val date = Date()
//        val current = formatter.format(date)
        rabbitTemplate.convertAndSend(myMap[action+".exchange"]!!,myMap[action+".key"]!!, TransactionWrapperTo(type=action, transaction =  message))
        println("writing to queue " + jacksonObjectMapper().writeValueAsString(TransactionWrapperTo(type=action, transaction =  message)))
        return "k"
    }
}