package buur.frederik.timetowork.dao

import buur.frederik.timetowork.model.User
import java.util.*

interface UserDao {

    fun insertUser(id: UUID? = null, user: User): Int

    fun selectAllUsers(): List<User>

    fun selectUserById(id: UUID): User?

    fun deleteUserById(id: UUID): Int

    fun updateUserById(id: UUID, user: User): Int

}