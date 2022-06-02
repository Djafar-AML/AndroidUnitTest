package com.example.unittest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test


class ComparedResourceTest {

    private lateinit var comparedResource: ComparedResource

    @Before
    fun setup() {
        comparedResource = ComparedResource()
    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = comparedResource.isEqual(context, R.string.app_name, "Unit Test")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentFromGivenString_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = comparedResource.isEqual(context, R.string.app_name, "UnitTest")
        assertThat(result).isFalse()
    }
}