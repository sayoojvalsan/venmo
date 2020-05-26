package com.venmo.home.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.*
import com.nhaarman.mockitokotlin2.*
import com.venmo.home.api.SearchRepository
import com.venmo.home.model.AlbumArtWork
import com.venmo.home.model.ITunesSearchResponse
import com.venmo.home.model.ResultsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.MockitoAnnotations
import retrofit2.Response
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException


@RunWith(JUnit4::class)
class HomeViewModelTest {
    private val observer: Observer<List<AlbumArtWork>> = mock()

    private lateinit var homeViewModel: HomeViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    var searchRepo: SearchRepository = mock()

    //var mock: SearchRepository = mock(SearchRepository::class.java)


    var response: Response<ITunesSearchResponse> = mock()

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() = runBlockingTest {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(mainThreadSurrogate)

        homeViewModel = HomeViewModel(searchRepo)
        homeViewModel.results.observeForever{observer}

        //Mock the service
        whenever(searchRepo.search(any(), any())).then {
            Response.success(createResponse())
        }
        whenever(response.isSuccessful).then {
            true
        }

        whenever(response.body()).then {
            createResponse()
        }
    }

    private fun createResponse() : ITunesSearchResponse{
        val resultItem: ResultsItem = ResultsItem(artistName = "Beetles")
        return ITunesSearchResponse(1, listOf(resultItem))
    }

    @Test
    fun getResults()  = runBlockingTest{
        homeViewModel.setQuery("Beetles", "US")

        homeViewModel.results.getOrAwaitValue()
        assertEquals(homeViewModel.results.getOrAwaitValue().size, 1)
        assertEquals(homeViewModel.results.getOrAwaitValue()[0].artistName, "Beetles")
    }

    fun <T> LiveData<T>.observeOnce(onChangeHandler: (T) -> Unit) {
        val observer = OneTimeObserver(handler = onChangeHandler)
        observe(observer, observer)
    }

    class OneTimeObserver<T>(private val handler: (T) -> Unit) : Observer<T>, LifecycleOwner {
        private val lifecycle = LifecycleRegistry(this)

        init {
            lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        }

        override fun getLifecycle(): Lifecycle = lifecycle

        override fun onChanged(t: T) {
            handler(t)
            lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        }
    }


    fun <T> LiveData<T>.getOrAwaitValue(
        time: Long = 2,
        timeUnit: TimeUnit = TimeUnit.SECONDS
    ): T {
        var data: T? = null
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(o: T?) {
                data = o
                latch.countDown()
                this@getOrAwaitValue.removeObserver(this)
            }
        }

        this.observeForever(observer)

        // Don't wait indefinitely if the LiveData is not set.
        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }

        @Suppress("UNCHECKED_CAST")
        return data as T
    }


}