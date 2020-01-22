package buur.frederik.timetowork.dao.account

interface IAccountDao {

    fun registerLogin(username: String, password: String)
    fun requestSessionKey(username: String, password: String): String
    fun authenticateBySessionKey(sessionKey: String): Boolean

}
