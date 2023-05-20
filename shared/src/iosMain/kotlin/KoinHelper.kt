import di.appModule
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf

fun initKoin() = startKoin {
    modules(appModule())
}

fun <T> KoinApplication.getDependency(objCClass: ObjCClass): T? =
    getOriginalKotlinClass(objCClass)?.let {
        koin.get(it, null) { parametersOf(it.simpleName) } as T
    }