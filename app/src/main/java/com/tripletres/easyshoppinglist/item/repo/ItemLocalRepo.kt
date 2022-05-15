package com.tripletres.easyshoppinglist.item.repo

import com.tripletres.easyshoppinglist.item.model.Item
import javax.inject.Inject

class ItemLocalRepo @Inject constructor(private val itemDao: ItemDao) {
    fun add(item: Item) = itemDao.insert(item)
}