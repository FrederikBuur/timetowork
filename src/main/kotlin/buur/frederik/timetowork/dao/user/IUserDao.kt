package buur.frederik.timetowork.dao.user

import buur.frederik.timetowork.model.User
import java.util.*

interface IUserDao {

    fun insertUser(id: UUID? = null, user: User): Int

    fun selectAllUsers(): List<User>

    fun selectUserById(id: UUID): User

    fun deleteUserById(id: UUID)

    fun updateUserById(id: UUID, user: User)

}