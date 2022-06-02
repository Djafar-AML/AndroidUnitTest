package com.example.unittest

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class RegisterValidationTest {

    private lateinit var registerValidation : RegisterValidation

    @Before
    fun setup() {
        registerValidation = RegisterValidation()
    }

    @Test
    fun `empty username returns false`() {

        registerValidation.validateUser(
            "",
            "123",
            "123"
        )

        val isUserValid = registerValidation.isUserValid()
        assertThat(isUserValid).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true` () {

        registerValidation.validateUser(
            "JJ",
            "a123",
            "a123"
        )

        val isUserValid = registerValidation.isUserValid()
        assertThat(isUserValid).isTrue()
    }

    @Test
    fun `username already exists returns false` () {

        registerValidation.validateUser(
            "Jeff",
            "a123",
            "a123"
        )



        val isUserValid = registerValidation.isUserValid()
        assertThat(isUserValid).isFalse()
    }

    @Test
    fun `empty password returns false` () {

        registerValidation.validateUser(
            "Cefer",
            "",
            ""
        )

        val isUserValid = registerValidation.isUserValid()
        assertThat(isUserValid).isFalse()
    }

    @Test
    fun `incorrectly confirmed password returns false` () {

        registerValidation.validateUser(
            "Cefer",
            "123",
            "124"
        )

        val isUserValid = registerValidation.isUserValid()
        assertThat(isUserValid).isFalse()
    }

    @Test
    fun `password with less than two digits` () {

        registerValidation.validateUser(
            "Cefer",
            "abcde1",
            "abcde1"
        )

        val isUserValid = registerValidation.isUserValid()
        assertThat(isUserValid).isFalse()
    }

}