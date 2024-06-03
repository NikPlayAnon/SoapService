package zb.ru.bzionservice.repository

//import com.rabbitmq.client.ConnectionFactory
//import com.rabbitmq.client.DeliverCallback
//import com.rabbitmq.client.Delivery
import jakarta.annotation.PostConstruct
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component
import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.model.TransactionNotice
import zb.ru.bzionservice.rabbit.PublisherController
import zb.ru.bzionservice.rabbit.RabbitMqConfig
import zb.ru.bzionservice.rabbit.SubscriberService
import java.util.*



@Component
class HandlingUnitRepositoryImpl(private val publisherController: PublisherController) : HandlingUnitRepository {
    @PostConstruct
    fun initData() {
        unitList += HandlingUnit(
            handlingUnitId = "R202011040000000519",
            cdfHight = "600",
            cdfWidth = "600",
            warehouse = "R0100",
            cdfLocation = "0001",
            cdfLocationSegmantNumber = "0004"
        )
        unitList += HandlingUnit(
            handlingUnitId = "R202011040000000638",
            cdfHight = "600",
            cdfWidth = "600",
            warehouse = "R0100",
            cdfLocation = "0001",
            cdfLocationSegmantNumber = "0004"
        )
        unitList += HandlingUnit(
            handlingUnitId = "R202011040000000880",
            cdfHight = "600",
            cdfWidth = "600",
            warehouse = "R0100",
            cdfLocation = "0001",
            cdfLocationSegmantNumber = "0004"
        )
        addToQueue(
            HandlingUnits(
                transactionId = "1",
                dateAndTime = "2024-02-14T08:57:23.676Z",
                actionCode = "locationUpdate",
                handlingUnit = unitList
            )
        )
        addToQueue(
            HandlingUnits(
                transactionId = "2",
                dateAndTime = "2024-02-14T08:57:23.676Z",
                actionCode = "sizeUpdate",
                handlingUnit = unitList
            )
        )
    }

    override fun findFirst(): HandlingUnits? {
        return absoluteUnit.poll()
    }

    override fun setResponse(response: TransactionNotice) {
        responseQueue.add(response)
        val mapper = "asd" //jacksonObjectMapper()
        println(response)
        println(responseQueue)
        publisherController.queue1()
    }

    override fun addToQueue(handlingUnitFromRabbit: HandlingUnits) {
        absoluteUnit.add(handlingUnitFromRabbit)
    }


    var unitList = listOf<HandlingUnit>()
    var absoluteUnit: Queue<HandlingUnits> = LinkedList<HandlingUnits>()
    var responseQueue: Queue<TransactionNotice> = LinkedList<TransactionNotice>()
}