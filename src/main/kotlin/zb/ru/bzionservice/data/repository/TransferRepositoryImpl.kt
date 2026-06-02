package zb.ru.bzionservice.data.repository

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.model.TransferItem
import zb.ru.bzionservice.model.TransferItems
import java.util.*

@Component
class TransferRepositoryImpl: TransferRepository {

    @PostConstruct
    fun initData() {
    }
    override fun findFirst(): TransferItems? {
//        var transferItem = TransferItem(
//            warehouse="R0200",
//            locationSource="200001",
//            locationTarget="200006",
//            item="         01362783045",
//            lot="240112-00094",
//            quantity="1000.36"
//        )
//        var transferItem2 = TransferItem(
//            warehouse="R0200",
//            locationSource="200006",
//            locationTarget="200001",
//            item="         01362783045",
//            lot="220706-a0149",
//            quantity="0.16"
//        )
//        var transferItems = TransferItems(
//            transactionId="3",
//            dateAndTime="2025-02-22T10:23:40",
//            actionCode="change",
//            user="s_perminov",
//            listOf(transferItem) //,transferItem2)
//        )
        if (absoluteUnit.size>0){println("queue TransferItems contains "+ (absoluteUnit.size-1) +" items ")}
        return absoluteUnit.poll()

    }

    override fun addToQueue(transferItemsFromRabbit: TransferItems) {
        absoluteUnit.add(transferItemsFromRabbit)
    }

    var absoluteUnit: Queue<TransferItems> = LinkedList<TransferItems>()
}