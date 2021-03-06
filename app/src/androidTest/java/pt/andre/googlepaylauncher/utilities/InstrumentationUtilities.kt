package pt.andre.googlepaylauncher.utilities

import androidx.test.platform.app.InstrumentationRegistry
import java.io.File
import java.io.InputStream

internal val density: Int
    get() = InstrumentationRegistry.getInstrumentation()
        .context.resources.displayMetrics.densityDpi

internal val filesDir: File
    get() = InstrumentationRegistry.getInstrumentation()
        .targetContext.filesDir

internal fun assets(name: String): InputStream {
    return InstrumentationRegistry.getInstrumentation()
        .context.resources.assets.open(name)
}