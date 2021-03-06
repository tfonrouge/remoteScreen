package com.fonrouge.remoteScreen.model

import com.fonrouge.fsLib.serializers.FSLocalDateTimeSerializer
import io.kvision.types.LocalDateTime
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
@com.fonrouge.fsLib.Collection("customerOrderHdrs")
data class CustomerOrderHdr(
    override var _id: String,
    override var numId: Int,
    var customerItm_id: String?,
    @Serializable(with = FSLocalDateTimeSerializer::class)
//    @Contextual
    var created: LocalDateTime,
    var status: String = "$",
    var userProfile: String
) : DocumentWithNumId<String> {

    @EncodeDefault(mode = EncodeDefault.Mode.NEVER)
    var customerItm: CustomerItm? = null

    val statusLabel: String
        get() {
            return customerOrderHdrStatusList.find { it.first == status }?.second ?: "?"
        }
}

val customerOrderHdrStatusList = listOf(
    "1" to "Pending Order",
    "0" to "Finished Order",
    "C" to "Cancelled Order",
    "$" to "New Order",
    "2" to "Order Ready"
)
