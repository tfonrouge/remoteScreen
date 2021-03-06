package com.fonrouge.remoteScreen.model

import io.kvision.types.LocalDateTime
import kotlinx.serialization.Contextual

@kotlinx.serialization.Serializable
data class DeliveryOrderItm(
    val _id: String,
    val customerOrderItm_id: String,
    val qtyDelivered: Int,
    @Contextual
    val dateDelivered: LocalDateTime,
    val status: String
) {
    val customerOrderItm: CustomerOrderItm? = null
    val customerItm: CustomerItm? = null
    val statusDeliver: String
        get() {
            return deliveryStatusList.find { it.first == status }?.second ?: "?"
        }
}

val deliveryStatusList = listOf(
    "N" to "NewOrder",
    "PK" to "Picking",
    "PD" to "Picked",
    "T" to "InTransit",
    "#" to "Delivered"
)
