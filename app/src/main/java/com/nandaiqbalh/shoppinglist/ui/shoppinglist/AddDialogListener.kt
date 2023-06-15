package com.nandaiqbalh.shoppinglist.ui.shoppinglist

import com.nandaiqbalh.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {

	fun onAddButtonClicked(shoppingItem: ShoppingItem)
}