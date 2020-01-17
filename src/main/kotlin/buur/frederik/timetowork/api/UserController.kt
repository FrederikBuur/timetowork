package buur.frederik.timetowork.api

import buur.frederik.timetowork.model.User
import buur.frederik.timetowork.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.lang.NonNull
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RequestMapping("/api/v1/user")
@RestController
class UserController @Autowired constructor(
        val userService: UserService
) {

    @PostMapping
    fun addUser(@Valid @NonNull @RequestBody user: User) = userService.addUser(user)

    @GetMapping
//    fun getAllUsers() = userService.getAllUsers()
    fun getAllUsers() = "Test is working cmon"

    @GetMapping(path = ["{id}"])
    fun getUser(@PathVariable("id") id: UUID) = userService.getUserById(id)

    @DeleteMapping(path = ["{id}"])
    fun deleteUser(@PathVariable("id") id: UUID) = userService.deleteUserById(id)

    @PutMapping(path = ["{id}"])
    fun updateUserById(@PathVariable("id") id: UUID,
                       @Valid @NonNull @RequestBody user: User) = userService.updateUserById(id, user)

}