package buur.frederik.timetowork.dao

import buur.frederik.timetowork.model.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository("fakeDao")
class FakeUserDataAccessService : UserDao {

    private val DB = ArrayList<User>()

    override fun insertUser(id: UUID?, user: User): Int {
        DB.add(User(id ?: UUID.randomUUID(), user.name))
        return 1
    }

    override fun selectAllUsers(): List<User> {
        return DB
    }

    override fun selectUserById(id: UUID): User? {
        return DB.singleOrNull { it.id == id }
    }

    override fun deleteUserById(id: UUID): Int {
        DB.removeIf { user ->
            user.id?.equals(id) ?: false
        }
        return 1
    }

    override fun updateUserById(id: UUID, user: User): Int {
        return selectUserById(id)?.let {
            val index = DB.indexOf(it)
            if (index >= 0) {
                DB[index] = User(id, user.name)
                1
            } else {
                0
            }
        } ?: 0
    }
}