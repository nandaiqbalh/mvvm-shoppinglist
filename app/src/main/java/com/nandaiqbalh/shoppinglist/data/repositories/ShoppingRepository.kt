package com.nandaiqbalh.shoppinglist.data.repositories

import com.nandaiqbalh.shoppinglist.data.db.ShoppingDatabase
import com.nandaiqbalh.shoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository(private val db: ShoppingDatabase) {
	suspend fun upsert(shoppingItem: ShoppingItem) = db.getShoppingDao().upsert(shoppingItem)

	suspend fun delete(shoppingItem: ShoppingItem) = db.getShoppingDao().delete(shoppingItem)

	fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}