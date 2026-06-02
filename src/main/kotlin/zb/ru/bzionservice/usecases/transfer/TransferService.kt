package zb.ru.bzionservice.usecases.transfer

import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.model.TransactionNotice
import zb.ru.bzionservice.model.TransferItems

interface TransferService {
    fun findFirstUnit() : TransferItems?

    fun setResponse(response: TransactionNotice): Unit
}