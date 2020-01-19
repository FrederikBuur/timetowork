package buur.frederik.timetowork.service

import buur.frederik.timetowork.model.User
import java.util.*

interface IUserService {

    fun createUser(user: User)
    fun getAllUsers(): List<User>
    fun getUserById(id: UUID): User
    fun deleteUserById(id: UUID)
    fun updateUserById(id: UUID, user: User)

}