package di

import coreModule
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class Helper : KoinComponent {
    fun initKoin() {
        startKoin {
            modules(coreModule())
        }.koin

    }
}
