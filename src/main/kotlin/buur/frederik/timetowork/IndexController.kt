package buur.frederik.timetowork

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping("/")
    fun getIndex(): String {
      return "Server is up and running!"
    }
    
    @GetMapping("/user")
    fun user(): String {
        return "user page"
    }
    
    @GetMapping("/admin")
    fun admin(): String {
        return "admin page"
    }

}