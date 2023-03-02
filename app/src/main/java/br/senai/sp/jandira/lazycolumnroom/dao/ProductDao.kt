package br.senai.sp.jandira.lazycolumnroom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.lazycolumnroom.model.Product

@Dao
interface ProductDao {

    @Insert
    fun save(product: Product): Long

    @Delete
    fun delete(product: Product): Int

    @Query("SELECT * FROM tbl_product ORDER BY product_name ASC")
    fun getAll(): List<Product>

}