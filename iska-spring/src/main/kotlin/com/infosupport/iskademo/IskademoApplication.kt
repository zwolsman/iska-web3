package com.infosupport.iskademo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class IskademoApplication

fun main(args: Array<String>) {
    runApplication<IskademoApplication>(*args)
}

@RestController
class IskaController {

    @GetMapping("/kms")
    fun readKms() = -1

    @PostMapping("/kms")
    fun saveKms(@RequestParam km: Int) = "TODO"

}