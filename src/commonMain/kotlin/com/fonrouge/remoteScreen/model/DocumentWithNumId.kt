package com.fonrouge.remoteScreen.model

import com.fonrouge.fsLib.model.base.BaseModel
import kotlin.js.JsExport

@JsExport
interface DocumentWithNumId<T> : BaseModel<T> {
    val numId: Int
}
