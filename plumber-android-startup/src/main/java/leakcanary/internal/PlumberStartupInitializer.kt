package leakcanary.internal

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import leakcanary.AndroidLeakFixes

class PlumberStartupInitializer : Initializer<PlumberStartupInitializer> {
  override fun create(context: Context) = apply {
    val application = context.applicationContext as Application
    AndroidLeakFixes.applyFixes(application)
  }
  override fun dependencies() = emptyList<Class<out Initializer<*>>>()
}
