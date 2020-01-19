package buur.frederik.timetowork.dao.user

import buur.frederik.timetowork.model.User
import jdk.jshell.spi.ExecutionControl
import org.springframework.stereotype.Repository
import java.util.*

@Repository("postgres")
class UserDataAccessService : IUserDao {
    override fun insertUser(id: UUID?, user: User): Int {
        return 0
    }

    override fun selectAllUsers(): List<User> {
        return emptyList()
    }

    override fun selectUserById(id: UUID): User {
        throw ExecutionControl.NotImplementedException("postgres select user by id")
    }

    override fun deleteUserById(id: UUID) {
    }

    override fun updateUserById(id: UUID, user: User) {
    }
}