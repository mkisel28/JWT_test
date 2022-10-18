package com.example


import com.example.plugins.*
import com.example.utils.TokenManager
import com.example.utils.User

import io.ktor.server.application.*



fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)


@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSecurity()
    configureRouting()

    println("ds")
    println(TokenManager().generateJWTToken(user = User()))
}

