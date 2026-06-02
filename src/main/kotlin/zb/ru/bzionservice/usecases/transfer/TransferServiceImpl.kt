package zb.ru.bzionservice.usecases.transfer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import zb.ru.bzionservice.data.rabbit.PublisherController
import zb.ru.bzionservice.data.rabbit.mapper.toRabbit.TransactionNoticeToRabbitMapper
import zb.ru.bzionservice.model.TransactionNotice
import zb.ru.bzionservice.data.repository.TransferRepositoryImpl
import zb.ru.bzionservice.model.TransferItems

@Service
class TransferServiceImpl : TransferService {
    @Autowired
    private val repository: TransferRepositoryImpl? = null
    @Autowired
    private val publisherController: PublisherController? = null

    override fun findFirstUnit() : TransferItems?{
        return repository?.findFirst()
    }

    override fun setResponse(response: TransactionNotice) {
        publisherController?.queueTransfer(TransactionNoticeToRabbitMapper().transform(response), response.actionCodeField)
    }
}