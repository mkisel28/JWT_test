package com.example.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm


class TokenManager ( ) {
    val audience =  "http://127.0.0.1:8080/helo"
    val secret =  "suckDick!@"
    val issuer =  "http://127.0.0.1:8080"
    val experationDate = System.currentTimeMillis() + 60000;

fun generateJWTToken(user: User): HashMap<String, String>
{



    val token = JWT.create()
        .withClaim("username", user.username)
        .withClaim("userId", user.id)
        .sign(Algorithm.HMAC256(secret))
    return hashMapOf("token" to token)

}

fun verificationJWT(): JWTVerifier{
    return  JWT.require(Algorithm.HMAC256(secret)).build()
}


}