package com.venmo.login.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.*
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.venmo.login.api.IRegistrationService
import com.venmo.login.api.ISessionRepo
import com.venmo.login.model.RegisterCodeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.MockitoAnnotations



@RunWith(JUnit4::class)
class RegistrationViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    var registrationService: IRegistrationService = mock()
    var sessionRepo: ISessionRepo = mock()

    lateinit var registrationViewModel : RegistrationViewModel

    private val observer: Observer<Boolean> = mock()


    @Before
    fun setUp() = runBlockingTest {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(mainThreadSurrogate)

        registrationViewModel = RegistrationViewModel(registrationService, sessionRepo)
        //Mock the service
        whenever(registrationService.sendCodeToPhone(any())).then {
            RegisterCodeResponse(listOf(), null)
        }
    }

    @Test
    fun sendCodeToPhone() = runBlockingTest {

        registrationViewModel.sendCodeToPhone(Phone("", ""))
        registrationViewModel.onVerificationCodeSent.observeForever(observer)
        verify(observer).onChanged(true)

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        registrationViewModel.onVerificationCodeSent.removeObserver(observer)
        mainThreadSurrogate.close()
    }

}