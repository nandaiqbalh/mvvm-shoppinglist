package com.nandaiqbalh.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.nandaiqbalh.shoppinglist.data.db.entities.ShoppingItem
import com.nandaiqbalh.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
	private val shoppingRepository: ShoppingRepository
) : ViewModel() {

	fun upsert(shoppingItem: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
		shoppingRepository.upsert(shoppingItem)
	}

	fun delete (shoppingItem: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
		shoppingRepository.delete(shoppingItem)
	}

	fun getAllShoppingItems() = shoppingRepository.getAllShoppingItems()

}