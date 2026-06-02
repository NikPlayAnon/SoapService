package zb.ru.bzionservice.usecases.container

import org.springframework.stereotype.Service
import zb.ru.bzionservice.data.rabbit.PublisherController
import zb.ru.bzionservice.data.rabbit.mapper.toRabbit.container.ContainerTransactionNoticeToRabbit
import zb.ru.bzionservice.data.repository.ContainerTransactionRepository
import zb.ru.bzionservice.model.ContainerTransaction
import zb.ru.bzionservice.model.ContainerTransactionNotice

@Service
class ContainerTransactionServiceImpl(val repository: ContainerTransactionRepository?, val publisherController: PublisherController?) : ContainerTransactionService {
    override fun findFirstUnit(): ContainerTransaction? {
        return repository?.findFirst()
    }

    override fun setResponse(response: ContainerTransactionNotice) {
        publisherController?.queueContainer(ContainerTransactionNoticeToRabbit().transform(response),"PlacementContainerMessage")
    }

}