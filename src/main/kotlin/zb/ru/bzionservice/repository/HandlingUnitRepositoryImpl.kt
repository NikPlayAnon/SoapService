package zb.ru.bzionservice.repository

//import com.rabbitmq.client.ConnectionFactory
//import com.rabbitmq.client.DeliverCallback
//import com.rabbitmq.client.Delivery
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.model.TransactionNotice
import java.util.*


@Component
class HandlingUnitRepositoryImpl : HandlingUnitRepository {
    @Value("\${spring.rabbitmq.port}")
    lateinit var rabbitmqPort: String

    @Value("\${spring.rabbitmq.username}")
    lateinit var rabbitmqUsername: String

    @Value("\${spring.rabbitmq.password}")
    lateinit var rabbitmqPassword: String

    @Value("\${spring.rabbitmq.queue}")
    lateinit var rabbitmqQueue: String

    @Value("\${spring.rabbitmq.host}")
    lateinit var rabbitmqUrl: String


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
        println(responseQueue)
    }

    override fun addToQueue(handlingUnitFromRabbit: HandlingUnits) {
        absoluteUnit.add(handlingUnitFromRabbit)
    }


    var unitList = listOf<HandlingUnit>()
    var absoluteUnit: Queue<HandlingUnits> = LinkedList<HandlingUnits>()
    var responseQueue: Queue<TransactionNotice> = LinkedList<TransactionNotice>()
}