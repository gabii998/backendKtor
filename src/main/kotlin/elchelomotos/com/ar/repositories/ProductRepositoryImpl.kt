package elchelomotos.com.ar.repositories

import elchelomotos.com.ar.AppDatabase
import elchelomotos.com.ar.data.entities.Producto
import elchelomotos.com.ar.data.tables.Productos
import org.ktorm.dsl.*

class ProductRepositoryImpl:ProductRepository {


    override fun getProductos(limit:String?,offset:String?): List<Producto> {
        var query = AppDatabase.getDatabase().from(Productos).select()
        if (limit != null){
           query = query.limit(limit.toInt())
        }
        if (offset != null){
           query = query.offset(offset.toInt())
        }

        val result = query.map {
            Producto(it[Productos.codProducto],it[Productos.precioPesos]?.toDouble(),it[Productos.precioDolar]?.toDouble(),it[Productos.nombre])
        }
        return result
    }
}