package zb.ru.bzionservice.data.repository

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.model.HandlingUnits
import java.util.*


@Component
class HandlingUnitRepositoryImpl() : HandlingUnitRepository {
    @PostConstruct
    fun initData() {
    }

    override fun findFirst(): HandlingUnits? {
        println("queue contains "+ (absoluteUnit.size-1) +" items ")
        return absoluteUnit.poll()
    }

    override fun addToQueue(handlingUnitFromRabbit: HandlingUnits) {
        absoluteUnit.add(handlingUnitFromRabbit)
    }


    var unitList = listOf<HandlingUnit>()
    var absoluteUnit: Queue<HandlingUnits> = LinkedList<HandlingUnits>()
}