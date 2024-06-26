package zb.ru.bzionservice.repository

//import com.rabbitmq.client.ConnectionFactory
//import com.rabbitmq.client.DeliverCallback
//import com.rabbitmq.client.Delivery
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.rabbit.dto.IonNotice
import zb.ru.bzionservice.model.TransactionNotice
//import zb.ru.bzionservice.model.toTransactionNoticeToRabbit
import zb.ru.bzionservice.rabbit.PublisherController
import zb.ru.bzionservice.rabbit.mapper.toRabbit.TransactionNoticeToRabbitMapper
import java.util.*
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import zb.ru.bzionservice.rabbit.mapper.toRabbit.IonNoticeToRabbit


@Component
class HandlingUnitRepositoryImpl(private val publisherController: PublisherController) : HandlingUnitRepository {
    @PostConstruct
    fun initData() {
    }

    override fun findFirst(): HandlingUnits? {
        return absoluteUnit.poll()
    }

    override fun setResponse(response: TransactionNotice) {
        responseQueue.add(response)
        publisherController.queue1(IonNoticeToRabbit().transform(response))
    }

    override fun addToQueue(handlingUnitFromRabbit: HandlingUnits) {
        absoluteUnit.add(handlingUnitFromRabbit)
    }


    var unitList = listOf<HandlingUnit>()
    var absoluteUnit: Queue<HandlingUnits> = LinkedList<HandlingUnits>()
    var responseQueue: Queue<TransactionNotice> = LinkedList<TransactionNotice>()
}