package zb.ru.bzionservice.service.handling

import zb.ru.bzionservice.model.HandlingUnits

interface HandlingUnitService {
    fun findFirstUnit() : HandlingUnits?

}