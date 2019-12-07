package com.wahdanz.pixabay.dummy

import com.wahdanz.pixabay.data.model.PixabayModel
import com.wahdanz.pixabay.domain.entity.PixbayEntity

object DummyData {
    val dummyDomainObject = PixbayEntity(0, "", "", "", listOf("das", "dss"), 1, 21, 12)
    val dummyDataObject = PixabayModel(
        0, "dummy", "dummy", 1, "dummy", "dummy",
        "dummy", 1, 12, "dummy", "dummy", 1, "12", 12, 12
    )
}