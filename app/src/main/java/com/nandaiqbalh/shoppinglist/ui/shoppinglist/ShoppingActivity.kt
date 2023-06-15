package com.nandaiqbalh.shoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nandaiqbalh.shoppinglist.R
import com.nandaiqbalh.shoppinglist.data.db.ShoppingDatabase
import com.nandaiqbalh.shoppinglist.data.db.entities.ShoppingItem
import com.nandaiqbalh.shoppinglist.data.repositories.ShoppingRepository
import com.nandaiqbalh.shoppinglist.databinding.ActivityShoppingBinding
import com.nandaiqbalh.shoppinglist.ui.shoppinglist.other.ShoppingItemAdapter
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity(), KodeinAware {

	override val kodein by kodein()
	private val factory: ShoppingViewModelFactory by instance()

	private var _binding: ActivityShoppingBinding? = null
	private val binding get() = _binding!!
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		_binding = ActivityShoppingBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

		val adapter = ShoppingItemAdapter(listOf(), viewModel)

		binding.rvShoppingItems.layoutManager = LinearLayoutManager(this)
		binding.rvShoppingItems.adapter = adapter

		viewModel.getAllShoppingItems().observe(this, Observer {
			adapter.items = it
			adapter.notifyDataSetChanged()
		})

		binding.fab.setOnClickListener {
			AddShoppingItemDialog(this,
			object : AddDialogListener{
				override fun onAddButtonClicked(shoppingItem: ShoppingItem) {
					viewModel.upsert(shoppingItem)
				}
			}).show()
		}


	}
}