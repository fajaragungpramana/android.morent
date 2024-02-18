package com.github.fajaragungpramana.morent.module.about

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.github.fajaragungpramana.morent.core.app.AppResult
import com.github.fajaragungpramana.morent.core.domain.user.UserInteractor
import com.github.fajaragungpramana.morent.core.domain.user.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class AboutViewModelTest {

    @get:Rule
    val instantTaskExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var userInteractor: UserInteractor

    private lateinit var viewModel: AboutViewModel

    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = AboutViewModel(userInteractor)
    }

    @Before
    fun setupDispatcher() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDownDispatcher() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getUser success should set state to UserData`() = runTest {
        val userExpected = User(
            avatar = "https://avatars.githubusercontent.com/u/47925662?s=400&u=e15d06caa4f49c9427a080c02f03b86f250f8a90&v=4",
            name = "Fajar Agung Pramana",
            email = "fajar.agungpramana77@gmail.com",
            about = "Experienced mobile developer with a strong track record in app development using Kotlin, Swift and Flutter. Over the past 3 years, I've successfully contributed to various projects, specializing in enhancing mobile apps. Proficient in translating complex requirements into clean, bug-free code, I excel in collaborating with cross-functional teams to deliver high-quality mobile apps."
        )
        Mockito.`when`(userInteractor.getUser()).thenReturn(flowOf(AppResult.Success(userExpected)))

        viewModel.setEvent(AboutEvent.USER)

        val result = viewModel.state.first()
        Assert.assertTrue(result is AboutState.UserData)
        Assert.assertEquals(userExpected, (result as AboutState.UserData).user)
    }

    @Test
    fun `getUser error should set state to MessageData`() = runTest {
        val messageExpected = "User is null"
        Mockito.`when`(userInteractor.getUser()).thenReturn(flowOf(AppResult.Error(messageExpected)))

        viewModel.setEvent(AboutEvent.USER)

        val result = viewModel.state.first()
        Assert.assertTrue(result is AboutState.MessageData)
        Assert.assertEquals(messageExpected, (result as AboutState.MessageData).message)
    }

}