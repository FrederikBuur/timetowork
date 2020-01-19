package buur.frederik.timetowork.service.authentication

import buur.frederik.timetowork.dao.authentication.IAuthenticationDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
@Qualifier("monolith")
class AuthenticationServiceMonolith @Autowired constructor(
        @Qualifier("fakeDao") private val authenticationDao: IAuthenticationDao
) : IAuthenticationService {

}
