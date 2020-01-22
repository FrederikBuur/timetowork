package buur.frederik.timetowork.api

import buur.frederik.timetowork.service.account.IAccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/account")
@RestController
class AccountController @Autowired constructor(
        @Qualifier("monolith") val accountService: IAccountService
){



}