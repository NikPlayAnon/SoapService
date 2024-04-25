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
        unitList += HandlingUnit(huid="R202011040000000519", cdfHght="600", cdfWdth="600", cwar="R0100", cdfLoca="0001", cdfLose="0004")
        unitList += HandlingUnit(huid="R202011040000000638", cdfHght="600", cdfWdth="600", cwar="R0100", cdfLoca="0001", cdfLose="0004")
        unitList += HandlingUnit(huid="R202011040000000880", cdfHght="600", cdfWdth="600", cwar="R0100", cdfLoca="0001", cdfLose="0004")

        absoluteUnit.add(HandlingUnits(mvid="1", datentime="2024-02-14T08:57:23.676Z", actioncode="locationUpdate", handlingUnit=unitList))
        absoluteUnit.add(HandlingUnits(mvid="2", datentime="2024-02-14T08:57:23.676Z", actioncode="sizeUpdate", handlingUnit=unitList))
    }
    override fun findFirst(): HandlingUnits? {
        return absoluteUnit.poll()
    }


    var unitList = listOf<HandlingUnit>()
    var absoluteUnit: Queue<HandlingUnits> = LinkedList<HandlingUnits>()

}