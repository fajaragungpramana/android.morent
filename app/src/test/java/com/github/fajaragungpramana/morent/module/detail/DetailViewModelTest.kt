package com.github.fajaragungpramana.morent.module.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.github.fajaragungpramana.morent.core.app.AppResult
import com.github.fajaragungpramana.morent.core.domain.house.HouseInteractor
import com.github.fajaragungpramana.morent.core.domain.house.model.House
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
class DetailViewModelTest {

    @get:Rule
    val instantTaskExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var houseInteractor: HouseInteractor

    private lateinit var viewModel: DetailViewModel

    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(true)
        viewModel = DetailViewModel(houseInteractor)
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
    fun `getHouse success should set state to HouseData`() = runTest {
        val houseExpected = House(
            id = 1,
            listImage = listOf(
                "https://picture.rumah123.com/r123/720x420-crop/primary_property/project/1833/1697340198_background_1833.jpg?noWatermark",
                "https://picture.rumah123.com/r123/1080x720-fit/primary_property/project/1833/1697340214_background_1833.jpg?noWatermark",
                "https://picture.rumah123.com/r123/1080x720-fit/primary_property/project/1833/1697340236_background_1833.jpg?noWatermark"
            ),
            title = "Metland Cibitung",
            price = "Rp656 Juta - 963 Juta",
            address = "Cibitung, Bekasi",
            overview = "Miliki Rumah 2 Lantai di Cibitung, Bekasi dengan harga terjangkau dan kemudahan akses transportasi, terdapat Stasiun Metland Telaga Murni yang berada dalam kawasan perumahan, serta fasilitas terbaik lainnya"
        )

        val houseId = houseExpected.id ?: 0
        Mockito.`when`(houseInteractor.getHouse(houseId)).thenReturn(flowOf(AppResult.Success(houseExpected)))

        viewModel.setEvent(DetailEvent.House(houseId))

        val result = viewModel.state.first()
        Assert.assertTrue(result is DetailState.HouseData)
        Assert.assertEquals(houseExpected, (result as DetailState.HouseData).house)
    }

    @Test
    fun `getHouse error should set state to MessageData`() = runTest {
        val messageExpected = "User is null"
        Mockito.`when`(houseInteractor.getHouse(1))
            .thenReturn(flowOf(AppResult.Error(messageExpected)))

        viewModel.setEvent(DetailEvent.House(1))

        val result = viewModel.state.first()
        Assert.assertTrue(result is DetailState.MessageData)
        Assert.assertEquals(messageExpected, (result as DetailState.MessageData).message)
    }

}