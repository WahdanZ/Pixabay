package com.wahdanz.pixabay.ui

import android.view.View
import com.wahdanz.pixabay.domain.entity.PixbayEntity
import com.wahdanz.pixabay.extensions.RecyclerAdapter

class HomeAdapter(
    itemList: List<PixbayEntity>,
    layoutResIds: Array<Int>,
    bindHolder: View.(PixbayEntity) -> Unit,
    itemClick: PixbayEntity.() -> Unit = {}
) : RecyclerAdapter<PixbayEntity>(itemList, layoutResIds, bindHolder, itemClick)