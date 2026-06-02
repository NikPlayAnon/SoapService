package zb.ru.bzionservice.data.repository

import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.model.TransferItems

interface TransferRepository {
    fun findFirst(): TransferItems?
    //    fun setResponse(response: TransactionNotice): Unit
    fun addToQueue(transferItemsFromRabbit: TransferItems)
}