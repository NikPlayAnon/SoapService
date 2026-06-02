package zb.ru.bzionservice.usecases.handling

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import zb.ru.bzionservice.data.rabbit.PublisherController
import zb.ru.bzionservice.data.rabbit.mapper.toRabbit.HandlingUnitsIonNoticeToRabbit
import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.model.TransactionNotice
import zb.ru.bzionservice.data.repository.HandlingUnitRepositoryImpl

@Service
class HandlingUnitServiceImpl : HandlingUnitService {
    @Autowired
    private val repository: HandlingUnitRepositoryImpl? = null
    @Autowired
    private val publisherController: PublisherController? = null

    override fun findFirstUnit() : HandlingUnits?{
        return repository?.findFirst()
    }

    override fun setResponse(response: TransactionNotice) {
//        repository?.setResponse(response)
        publisherController?.queue1(HandlingUnitsIonNoticeToRabbit().transform(response), response.actionCodeField)
    }
}