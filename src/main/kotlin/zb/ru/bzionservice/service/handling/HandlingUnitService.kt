package zb.ru.bzionservice.service.handling

import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.model.TransactionNotice

interface HandlingUnitService {
    fun findFirstUnit() : HandlingUnits?

    fun setResponse(response: TransactionNotice): Unit
}