package com.fonrouge.remoteScreen

import com.fonrouge.remoteScreen.services.CasaDulceService
import io.kvision.state.ObservableValue
import io.kvision.toast.Toast

object Model {

    private val casaDulceService = CasaDulceService()

    val obsProfile = ObservableValue(UserProfile())

    suspend fun ping(hello: String) {
        Security.withAuth {
            Toast.success(casaDulceService.ping(hello))
        }
    }

    suspend fun readProfile() {
        obsProfile.value = casaDulceService.getProfile()
    }
}