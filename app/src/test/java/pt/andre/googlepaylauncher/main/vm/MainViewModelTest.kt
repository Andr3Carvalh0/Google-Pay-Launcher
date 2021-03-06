package pt.andre.googlepaylauncher.main.vm

import android.content.Intent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import pt.andre.googlepaylauncher.main.apps.ApplicationManager
import kotlin.random.Random

internal class MainViewModelTest {

    private val id = GOOGLE_PAY_PACKAGE
    private val applicationManager = mock<ApplicationManager>()
    private val intent = mock<Intent>().apply {
        whenever(toString()).thenReturn("${Random.nextInt()}")
    }

    @Test
    fun `when application isnt installed we emit error message`() = runBlocking {
        runMainViewModelTests()
    }

    @Test
    fun `when application is installed we emit the application intent`() = runBlocking {
        runMainViewModelTests(intent)
    }

    private fun runMainViewModelTests(
        intent: Intent? = null
    ) = runBlocking {
        val vm = MainViewModel(applicationManager)

        whenever(applicationManager.getApplicationStartIntent(id)).thenReturn(intent)

        vm.initialize()

        assertEquals(intent, vm.intent.first())
        assertEquals(intent == null, vm.error.value)
    }
}
