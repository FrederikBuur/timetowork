package buur.frederik.timetowork.dao.account

import buur.frederik.timetowork.model.Account
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.server.ResponseStatusException
import java.lang.Exception
import java.security.SecureRandom
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

@Repository("fakeAccountDao")
class AccountDataAccessServiceFake : IAccountDao {
	
	private val activeSessions = HashMap<String, String>() // TODO should not be here - create auth manager
	private val accounts = ArrayList<Account>()
	
	override fun registerLogin(username: String, password: String) {
		if (usernameIsAvailable(username)) {
			val id = UUID.randomUUID()
			val userId = UUID.randomUUID()
			accounts.add(Account(id = id,
					username = username,
					password = password,
					userId = userId
			))
		} else {
			throw ResponseStatusException(HttpStatus.CONFLICT, "Username is already taken")
		}
	}
	
	override fun requestSessionKey(username: String, password: String): String {
		val secureRandom = SecureRandom()
		val base64Encoder = Base64.getUrlEncoder()
		
		login(username, password)
		
		val randomBytes = ByteArray(24)
		secureRandom.nextBytes(randomBytes)
		return base64Encoder.encodeToString(randomBytes).also {
			activeSessions[it] = username
		}
		
	}
	
	override fun authenticateBySessionKey(sessionKey: String): Boolean { // TODO should not be here - in auth manager
		return activeSessions.containsKey(sessionKey)
	}
	
	private fun login(username: String, password: String) {
		throw Exception()
	}
	
	private fun usernameIsAvailable(username: String) = !accounts.any { account -> account.username == username }
	
}
