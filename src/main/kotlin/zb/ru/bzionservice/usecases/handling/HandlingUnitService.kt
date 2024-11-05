package zb.ru.bzionservice.usecases.handling

import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.model.TransactionNotice

interface HandlingUnitService {
    fun findFirstUnit() : HandlingUnits?

    fun setResponse(response: TransactionNotice): Unit
}