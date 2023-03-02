package br.senai.sp.jandira.lazycolumnroom.dao.repository

import android.content.Context
import br.senai.sp.jandira.lazycolumnroom.dao.ProductDb
import br.senai.sp.jandira.lazycolumnroom.model.Product

class ProductRepository(context: Context) {

    private val db = ProductDb.getDatabase(context).productDao()

    //retorna lista de produtos
    fun getProductList(): List<Product> {
        return db.getAll()
    }

    fun save(product: Product): Long{
        return db.save(product)
    }

}