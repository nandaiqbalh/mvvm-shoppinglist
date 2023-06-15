package com.nandaiqbalh.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.nandaiqbalh.shoppinglist.R
import com.nandaiqbalh.shoppinglist.data.db.entities.ShoppingItem
import com.nandaiqbalh.shoppinglist.databinding.DialogAddShoppingItemBinding

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) :
	AppCompatDialog(context) {

	private var _binding: DialogAddShoppingItemBinding? = null
	private val binding get() = _binding!!

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		_binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.tvAdd.setOnClickListener {

			val name = binding.etName.text.toString()
			val amount = binding.etAmount.text.toString()

			if (name.isEmpty() || amount.isEmpty()) {
				Toast.makeText(context, "Please enter all the information!", Toast.LENGTH_SHORT)
					.show()
				return@setOnClickListener
			}

			val item = ShoppingItem(name, amount.toInt())
			addDialogListener.onAddButtonClicked(item)
			dismiss()

		}

		binding.tvCancel.setOnClickListener {
			cancel()
		}
	}
}