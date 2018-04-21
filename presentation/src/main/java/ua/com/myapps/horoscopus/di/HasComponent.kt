package ua.com.myapps.horoscopus.di

/**
 * Interface representing a contract for clients that contains a component for dependency injection.
 */
interface HasComponent<C> {
    fun getComponent(): C
}