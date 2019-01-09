package com.infosupport.iskademo

import com.infosupport.com.iskademo.IskaContract
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.gas.DefaultGasProvider

@SpringBootApplication
class IskademoApplication

fun main(args: Array<String>) {
    runApplication<IskademoApplication>(*args)
}

object Web3Config {
    val credentials = Credentials.create("c6d79ddae40f8c9b9aa619d55c149f2724e28278b5ee3d4e1eb816d44398c5bc")
    val web3j = Web3j.build(HttpService("HTTP://127.0.0.1:8545"))

    val contract = IskaContract.load("0x790Eb2C98CaE0760cB3994A827eFe07D57D52B78", web3j, credentials, DefaultGasProvider())
}

@RestController
class IskaController {

    @GetMapping("/kms")
    fun readKms() = Web3Config.contract.kmStand.send().toInt()

    @PostMapping("/kms")
    fun saveKms(@RequestParam km: Int) : String {
        val tx = Web3Config.contract.updateKmStand(km.toBigInteger()).send()
        return "OK: ${tx.transactionHash}"
    }


}