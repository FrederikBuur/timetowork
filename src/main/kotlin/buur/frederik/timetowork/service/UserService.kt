package buur.frederik.timetowork.service

import buur.frederik.timetowork.dao.UserDao
import buur.frederik.timetowork.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService @Autowired constructor(
        @Qualifier("fakeDao") private val userDao: UserDao
//        @Qualifier("postgres") private val userDao: UserDao
) {

    fun addUser(user: User): Int {
        userDao.insertUser(user = user)
        return 1
    }

    fun getAllUsers() = userDao.selectAllUsers()

    fun getUserById(id: UUID) = userDao.selectUserById(id)

    fun deleteUserById(id: UUID) = userDao.deleteUserById(id)

    fun updateUserById(id: UUID, user: User) = userDao.updateUserById(id, user)

}