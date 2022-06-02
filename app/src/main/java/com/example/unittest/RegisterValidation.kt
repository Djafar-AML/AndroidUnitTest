package com.example.unittest

class RegisterValidation {

    private var isUserValid = true
    private val existingUsers = listOf("Jeff", "Hooman")

    /**
     * the input is not valid if...
     * ...the username/password is empty
     * ...the username is already taken
     * ...the confirmed password is not the same as the real password
     * ...the password contains less than 2 digits
     */

    fun validateUser (
        username: String,
        password: String,
        confirmedPassword: String) {

        if (username.isEmpty() || password.isEmpty())
            isUserValid = false
        if (username in existingUsers)
            isUserValid = false
        if (password != confirmedPassword)
            isUserValid = false
        if (password.count { it.isDigit() } < 2)
            isUserValid = false

    }

    fun isUserValid(): Boolean {
        return isUserValid
    }
}