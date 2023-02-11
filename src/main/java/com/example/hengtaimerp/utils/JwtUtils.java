package com.example.hengtaimerp.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.hengtaimerp.entity.User;

import java.util.Calendar;

public class JwtUtils {


    private static final String STRING = "285a65993de188f8b9ff31118968d37cf5d1f722ae66030c41b028c35ed7d17f";
    private static final String ISSUER = "e5a08ffd3d7509c66e79642edbdcd8ed889269a7164c718afca541304188423d";

    public JwtUtils() {
    }


    public static String JwtToken(User user) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 1);//一天

        return JWT.create()
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withExpiresAt(instance.getTime())
                .withIssuer(ISSUER)
                .sign(Algorithm.HMAC256(STRING));
    }
    public static void verify(String token){
        JWT.require(Algorithm.HMAC256(STRING)).build().verify(token);
    }



}
