package buur.frederik.timetowork.api

import buur.frederik.timetowork.model.User
import buur.frederik.timetowork.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/user")
@RestController
class UserController @Autowired constructor(
        val userService: UserService
) {

    @PostMapping
    fun addUser(@RequestBody user: User) {
        userService.addUser(user)
    }

    @GetMapping
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

}