package com.fonrouge.remoteScreen.database

import com.fonrouge.fsLib.mongoDb.mongoDbCollection
import com.fonrouge.remoteScreen.model.InventoryItm

val inventoryItmDb = mongoDbCollection<InventoryItm>()
