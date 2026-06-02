package zb.ru.bzionservice.data.repository

import zb.ru.bzionservice.model.ContainerTransaction
import zb.ru.bzionservice.model.HandlingUnits

interface ContainerTransactionRepository {
    fun findFirst(): ContainerTransaction?
    //    fun setResponse(response: TransactionNotice): Unit
    fun addToQueue(containerTransactionFromRabbit: ContainerTransaction)
}