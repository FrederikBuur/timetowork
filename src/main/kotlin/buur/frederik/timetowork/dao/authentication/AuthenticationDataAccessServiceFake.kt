package buur.frederik.timetowork.dao.authentication

import buur.frederik.timetowork.model.Account
import org.springframework.stereotype.Repository
import java.security.SecureRandom
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

@Repository("fakeDao")
class AuthenticationDataAccessServiceFake : IAuthenticationDao {

    private val activeSessions = HashMap<String, String>()
    private val accounts = ArrayList<Account>()

    override fun registerLogin(username: String, password: String): UUID? {
        return if (usernameIsAvailable(username)) {
            val id = UUID.randomUUID()
            accounts.add(Account(
                    id = id,
                    username = username,
                    password = password
            ))
            id
        } else {
            null
        }
    }

    override fun requestSessionKey(username: String, password: String): String {
        val secureRandom = SecureRandom()
        val base64Encoder = Base64.getUrlEncoder()

        val randomBytes = ByteArray(24)
        secureRandom.nextBytes(randomBytes)
        return base64Encoder.encodeToString(randomBytes).also {
            activeSessions[it] = username
        }

    }

    override fun authenticateBySessionKey(sessionKey: String): Boolean {
        return activeSessions.containsKey(sessionKey)
    }

    private fun usernameIsAvailable(username: String) = !accounts.any { account -> account.username == username }

}
