package com.nandaiqbalh.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nandaiqbalh.shoppinglist.data.repositories.ShoppingRepository

class ShoppingViewModelFactory(
	private val shoppingRepository: ShoppingRepository
) : ViewModelProvider.NewInstanceFactory() {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		return ShoppingViewModel(shoppingRepository) as T
	}
}