package aej.kotlin.day1.tugas2.controller

import aej.kotlin.day1.tugas2.model.BaseResponse
import aej.kotlin.day1.tugas2.model.user.UserDatabase
import aej.kotlin.day1.tugas2.model.user.UserRequest
import aej.kotlin.day1.tugas2.service.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/aej/2/user")
class UserController {
    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    suspend fun getUsers(): BaseResponse<List<UserDatabase>> {
        return BaseResponse(
            code = "200",
            message = "data berhasil di ambil",
            data = userService.getUsers()
        )
    }

    @PostMapping
    suspend fun addUser(@RequestBody userRequest: UserRequest): BaseResponse<UserDatabase> {
        return BaseResponse(
            code = "200",
            message = "User berhasil ditambahkan",
            data = userService.addUser(userRequest)
        )
    }

    @PutMapping("/{id}")
    suspend fun updateUser(@PathVariable id:String, @RequestBody userRequest: UserRequest): BaseResponse<UserDatabase>  {
        return BaseResponse(
            code = "200",
            message = "User Berhasil di Edit",
            data = userService.updateUser(id, userRequest)
        )
    }
}