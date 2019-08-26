package com.example.org.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.org.coderswag.Model.Product
import com.example.org.coderswag.R
import com.example.org.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.activity_product_detail.productImage
import kotlinx.android.synthetic.main.activity_product_detail.productName
import kotlinx.android.synthetic.main.activity_product_detail.productPrice
import kotlinx.android.synthetic.main.product_list_item.*

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        println("name: ${product.title}, price: ${product.price}")
        productName.text = product.title
        productPrice.text = product.price
        val resourceId = this.resources.getIdentifier(product.image,
            "drawable", this.packageName)
        productImage.setImageResource(resourceId)
        productDescription.text = "Description: This is one of our best product, was recently imported from Israel, has a very high demand. Buy it before no item is left."
    }
}
