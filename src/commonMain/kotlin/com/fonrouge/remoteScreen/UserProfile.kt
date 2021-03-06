package com.fonrouge.remoteScreen

import kotlinx.serialization.Serializable

@Serializable
data class UserProfile(
    val id: String? = null,
    val name: String? = null,
    val username: String? = null,
    val password: String? = null,
    val password2: String? = null,
)
