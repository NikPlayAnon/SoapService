package zb.ru.bzionservice.repository

import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.model.TransactionNotice

interface HandlingUnitRepository {
    fun findFirst(): HandlingUnits?
    fun setResponse(response: TransactionNotice): Unit
    fun addToQueue(handlingUnitFromRabbit: HandlingUnits)
}