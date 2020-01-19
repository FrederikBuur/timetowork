package buur.frederik.timetowork.api

import buur.frederik.timetowork.service.authentication.AuthenticationServiceMonolith
import buur.frederik.timetowork.service.authentication.IAuthenticationService
import buur.frederik.timetowork.service.user.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/authentication")
@RestController
class AuthenticationController @Autowired constructor(
        @Qualifier("monolith") val authenticationService: IAuthenticationService
){



}