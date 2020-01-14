package buur.frederik.timetowork.dao

import buur.frederik.timetowork.model.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository("postgres")
class UserDataAccessService : UserDao {
    override fun insertUser(id: UUID?, user: User): Int {
        return 0
    }

    override fun selectAllUsers(): List<User> {
        return emptyList()
    }

    override fun selectUserById(id: UUID): User? {
        return null
    }

    override fun deleteUserById(id: UUID): Int {
        return 0
    }

    override fun updateUserById(id: UUID, user: User): Int {
        return 0
    }
}