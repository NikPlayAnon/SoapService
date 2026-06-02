package zb.ru.bzionservice.data.repository

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import zb.ru.bzionservice.model.Container
import zb.ru.bzionservice.model.ContainerTransaction
import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.model.HandlingUnits
import java.util.*

@Component
class ContainerTransactionRepositoryImpl() : ContainerTransactionRepository {
    @PostConstruct
    fun initData() {
//        addToQueue(ContainerTransaction(transactionId = "4353545325", transactionStatus = "RUNNING", transactionDate = "2025-11-13T19:53:07.71026", user = "n_bogomolov", container = Container(code = "R020000009", warehouseCode = "R0100", binCode = "01-001-002", null)))
    }


    override fun findFirst(): ContainerTransaction? {
        if (containerTransactionQueue.size>0){println("queue ContainerTransaction contains "+ (containerTransactionQueue.size-1) +" items ")}
        return containerTransactionQueue.poll()
    }

    override fun addToQueue(containerTransactionFromRabbit: ContainerTransaction) {
        containerTransactionQueue.add(containerTransactionFromRabbit)
        println("ContainerTransaction "+ (containerTransactionFromRabbit.transactionId) +" added to queue ")
    }

    var unitList = listOf<ContainerTransaction>()
    var containerTransactionQueue: Queue<ContainerTransaction> = LinkedList<ContainerTransaction>()
}