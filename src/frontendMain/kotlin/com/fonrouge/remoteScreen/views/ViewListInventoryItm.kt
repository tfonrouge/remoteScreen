package com.fonrouge.remoteScreen.views

import com.fonrouge.fsLib.apiLib.AppScope
import com.fonrouge.fsLib.layout.tabulatorCommon
import com.fonrouge.fsLib.lib.UrlParams
import com.fonrouge.fsLib.view.ViewList
import com.fonrouge.remoteScreen.CatalogType
import com.fonrouge.remoteScreen.UploadCatalog
import com.fonrouge.remoteScreen.config.ConfigViewImpl.Companion.ConfigViewListInventoryItm
import com.fonrouge.remoteScreen.model.InventoryItm
import com.fonrouge.remoteScreen.services.DataListService
import com.fonrouge.remoteScreen.services.DataListServiceManager
import io.kvision.core.Container
import io.kvision.core.FlexDirection
import io.kvision.html.Span
import io.kvision.html.button
import io.kvision.panel.flexPanel
import io.kvision.tabulator.ColumnDefinition
import io.kvision.tabulator.Editor
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromDynamic

class ViewListInventoryItm(
    override var urlParams: UrlParams?
) : ViewList<InventoryItm, DataListService>(
    configView = ConfigViewListInventoryItm,
    serverManager = DataListServiceManager,
    function = DataListService::inventoryItm
) {

    override val columnDefinitionList: List<ColumnDefinition<InventoryItm>> = listOf(
//                    ColumnDefinition(
//                        title = "#",
//                        formatter = Formatter.ROWNUM
//                    ),
        ColumnDefinition(
            title = InventoryItm::_id.name,
            field = InventoryItm::_id.name,
            headerFilter = Editor.NUMBER
        ),
        ColumnDefinition(
            title = InventoryItm::name.name,
            field = InventoryItm::name.name,
            headerFilter = Editor.INPUT
        ),
        ColumnDefinition(
            title = InventoryItm::size.name,
//                        field = InventoryItm::sizeData.name,
            headerFilter = Editor.INPUT,
            formatterComponentFunction = { cell, onRendered, data ->
                val o = Json.decodeFromDynamic<InventoryItm>(data.asDynamic())
                console.warn("DATA", o)
                Span(o.size)
            }
        ),
        ColumnDefinition(
            title = InventoryItm::upc.name,
            field = InventoryItm::upc.name,
            headerFilter = Editor.INPUT
        ),
        ColumnDefinition(
            title = InventoryItm::departmentName.name,
            field = InventoryItm::departmentName.name,
            headerFilter = Editor.INPUT
        ),
    )

    override fun pageListBody(container: Container) {
        container.apply {
            tabulatorCommon(this@ViewListInventoryItm, columnDefinitionList)
            flexPanel(direction = FlexDirection.ROW) {
                button(text = "Upload Product Catalog").onClick {
                    val uploadCatalog = UploadCatalog(CatalogType.Products)
                    AppScope.launch {
                        uploadCatalog.getResult()
                        tabulator?.reload()
                    }
                }
            }
        }
    }
}
