package com.fonrouge.remoteScreen.views

import com.fonrouge.fsLib.layout.tabulatorCommon
import com.fonrouge.fsLib.lib.UrlParams
import com.fonrouge.fsLib.view.ViewList
import com.fonrouge.remoteScreen.CatalogType
import com.fonrouge.remoteScreen.UploadCatalog
import com.fonrouge.remoteScreen.config.ConfigViewImpl.Companion.ConfigViewListCustomerItm
import com.fonrouge.remoteScreen.model.CustomerItm
import com.fonrouge.remoteScreen.services.DataListService
import com.fonrouge.remoteScreen.services.DataListServiceManager
import io.kvision.core.Container
import io.kvision.core.FlexDirection
import io.kvision.html.button
import io.kvision.panel.flexPanel
import io.kvision.tabulator.ColumnDefinition
import io.kvision.tabulator.Editor

class ViewListCustomerItm(
    override var urlParams: UrlParams?,
) : ViewList<CustomerItm, DataListService>(
    configView = ConfigViewListCustomerItm,
    serverManager = DataListServiceManager,
    function = DataListService::customerItm
) {
    override val columnDefinitionList: List<ColumnDefinition<CustomerItm>> = listOf(
        ColumnDefinition(
            title = CustomerItm::_id.name,
            field = CustomerItm::_id.name,
            headerFilter = Editor.NUMBER
        ),
        ColumnDefinition(
            title = CustomerItm::company.name,
            field = CustomerItm::company.name,
            headerFilter = Editor.INPUT,
        ),
        ColumnDefinition(
            title = CustomerItm::lastName.name,
            field = CustomerItm::lastName.name,
            headerFilter = Editor.INPUT,
        ),
        ColumnDefinition(
            title = CustomerItm::firstName.name,
            field = CustomerItm::firstName.name,
            headerFilter = Editor.INPUT,
        ),
        ColumnDefinition(
            title = CustomerItm::street.name,
            field = CustomerItm::street.name,
            headerFilter = Editor.INPUT,
        ),
        ColumnDefinition(
            title = CustomerItm::city.name,
            field = CustomerItm::city.name,
            headerFilter = Editor.INPUT,
        ),
        ColumnDefinition(
            title = CustomerItm::state.name,
            field = CustomerItm::state.name,
            headerFilter = Editor.INPUT,
        ),
        ColumnDefinition(
            title = CustomerItm::zip.name,
            field = CustomerItm::zip.name,
            headerFilter = Editor.INPUT,
        ),
        ColumnDefinition(
            title = CustomerItm::phone1.name,
            field = CustomerItm::phone1.name,
            headerFilter = Editor.INPUT,
        ),
        ColumnDefinition(
            title = CustomerItm::email.name,
            field = CustomerItm::email.name,
            headerFilter = Editor.INPUT,
        ),
    )

    override fun pageListBody(container: Container) {
        container.apply {
            tabulatorCommon(viewList = this@ViewListCustomerItm, columnDefinitionList = columnDefinitionList)
            flexPanel(direction = FlexDirection.ROW) {
                button(text = "Upload Customer Catalog").onClick {
                    val uploadCatalog = UploadCatalog(CatalogType.Customers)
//                AppScope.launch {
//                    uploadCatalog.getResult()
//                    tabRemote.reload()
//                }
                }
            }
        }
    }
}
