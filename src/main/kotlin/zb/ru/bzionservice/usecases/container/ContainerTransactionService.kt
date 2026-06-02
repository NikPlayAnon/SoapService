package zb.ru.bzionservice.usecases.container

import zb.ru.bzionservice.model.ContainerTransaction
import zb.ru.bzionservice.model.ContainerTransactionNotice
import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.model.TransactionNotice

interface ContainerTransactionService {
    fun findFirstUnit() : ContainerTransaction?

    fun setResponse(response: ContainerTransactionNotice): Unit
}