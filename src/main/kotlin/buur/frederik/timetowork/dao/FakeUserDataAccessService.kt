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
//        return DB.stream().filter { user -> user.id.equals(id) }
//                .findFirst()
    }

    override fun deleteUserById(id: UUID): Int {
        return 1
    }

    override fun updateUserById(id: UUID, user: User): Int {
        return 1
    }
}