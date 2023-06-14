package com.nandaiqbalh.shoppinglist

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShopingDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun upsert(shoppingItem: ShoppingItem)

	@Delete
	suspend fun delete(shoppingItem: ShoppingItem)

	@Query("SELECT * FROM shopping_items")
	fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}