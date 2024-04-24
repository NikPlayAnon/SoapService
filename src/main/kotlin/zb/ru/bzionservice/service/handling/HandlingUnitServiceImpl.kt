package zb.ru.bzionservice.service.handling

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import zb.ru.bzionservice.model.HandlingUnits
import zb.ru.bzionservice.repository.HandlingUnitRepositoryImpl

@Service
class HandlingUnitServiceImpl : HandlingUnitService {
    @Autowired
    private val repository: HandlingUnitRepositoryImpl? = null
    override fun findFirstUnit() : HandlingUnits?{
        return repository?.findFirst()
    }
}