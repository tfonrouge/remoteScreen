package com.fonrouge.remoteScreen.database

import com.fonrouge.fsLib.mongoDb.mongoDbCollection
import com.fonrouge.remoteScreen.CustomerItm

val customerItmDb = mongoDbCollection<CustomerItm>()
