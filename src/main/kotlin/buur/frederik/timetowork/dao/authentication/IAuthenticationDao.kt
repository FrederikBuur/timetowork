package buur.frederik.timetowork.dao.authentication

import java.util.*

interface IAuthenticationDao {

    fun registerLogin(username: String, password: String): UUID?
    fun requestSessionKey(username: String, password: String): String
    fun authenticateBySessionKey(sessionKey: String): Boolean

}
