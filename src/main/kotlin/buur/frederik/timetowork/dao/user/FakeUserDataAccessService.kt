package buur.frederik.timetowork.dao.user

import buur.frederik.timetowork.model.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository("fakeDao")
class FakeUserDataAccessService : IUserDao {

    private val DB = ArrayList<User>()

    override fun insertUser(id: UUID?, user: User): Int {
        DB.add(User(id ?: UUID.randomUUID(), user.firstName, user.lastName, user.imageUrl))
        return 1
    }

    override fun selectAllUsers(): List<User> {
        return DB
    }

    override fun selectUserById(id: UUID): User {
        return DB.single { it.id == id }
    }

    override fun deleteUserById(id: UUID) {
        DB.removeIf { user ->
            user.id == id
        }
    }

    override fun updateUserById(id: UUID, user: User) {
        selectUserById(id).let {
            val index = DB.indexOf(it)
            if (index >= 0) {
                DB[index] = User(id, user.firstName, user.lastName, user.imageUrl)
                1
            } else {
                0
            }
        }
    }
}