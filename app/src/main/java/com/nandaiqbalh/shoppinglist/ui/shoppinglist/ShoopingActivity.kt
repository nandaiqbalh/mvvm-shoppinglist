package com.nandaiqbalh.shoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.nandaiqbalh.shoppinglist.R
import com.nandaiqbalh.shoppinglist.data.db.ShoppingDatabase
import com.nandaiqbalh.shoppinglist.data.repositories.ShoppingRepository

class ShoopingActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_shopping)

		val database = ShoppingDatabase(this)
		val shoppingRepository = ShoppingRepository(database)
		val factory = ShoppingViewModelFactory(shoppingRepository)

		val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)
	}
}