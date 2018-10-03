package com.example.murbanski.bhbets;

class AccessTokenStore {

    private static String token;

    static void put(String accessToken) {
        token = accessToken;
    }

    static String get() {
        return token;
    }
}
