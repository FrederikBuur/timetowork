package buur.frederik.timetowork.service.account

import buur.frederik.timetowork.dao.account.IAccountDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
@Qualifier("monolith")
class AccountServiceMonolith @Autowired constructor(
        @Qualifier("fakeAccountDao") private val accountDao: IAccountDao
) : IAccountService {

}
