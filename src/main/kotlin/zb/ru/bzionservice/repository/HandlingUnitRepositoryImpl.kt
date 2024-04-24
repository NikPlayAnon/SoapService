package zb.ru.bzionservice.repository

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import zb.ru.bzionservice.model.HandlingUnit
import zb.ru.bzionservice.model.HandlingUnits
import java.util.Queue
import java.util.LinkedList

@Component
class HandlingUnitRepositoryImpl : HandlingUnitRepository  {

    @PostConstruct
    fun initData() {
        unitList += HandlingUnit(handlingUnitID="R202011040000000519", customHight="600", customWidth="600", warehouse="R0100", customWerehouseLocation="0001", customNumberInPlace="0004")
        unitList += HandlingUnit(handlingUnitID="R202011040000000638", customHight="600", customWidth="600", warehouse="R0100", customWerehouseLocation="0001", customNumberInPlace="0004")
        unitList += HandlingUnit(handlingUnitID="R202011040000000880", customHight="600", customWidth="600", warehouse="R0100", customWerehouseLocation="0001", customNumberInPlace="0004")

        absoluteUnit.add(HandlingUnits(TransactionId="1", dateAndTime="2024-02-14T08:57:23.676Z", actionCode="locationUpdate", handlingUnit=unitList))
        absoluteUnit.add(HandlingUnits(TransactionId="1", dateAndTime="2024-02-14T08:57:23.676Z", actionCode="sizeUpdate", handlingUnit=unitList))
    }
    override fun findFirst(): HandlingUnits? {
        return absoluteUnit.poll()
    }


    var unitList = listOf<HandlingUnit>()
    var absoluteUnit: Queue<HandlingUnits> = LinkedList<HandlingUnits>()

}