package zb.ru.bzionservice.repository

import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.model.HandlingUnits

interface HandlingUnitRepository {
    fun findFirst(): HandlingUnits?
}