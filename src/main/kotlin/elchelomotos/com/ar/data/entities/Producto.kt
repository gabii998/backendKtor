package elchelomotos.com.ar.data.entities

import elchelomotos.com.ar.data.tables.Productos
import org.ktorm.dsl.QueryRowSet

data class Producto(val codProducto:String?,val precioPesos:Double?,val precioDolar:Double?,val nombre:String?):Entity<Producto>() {

    override fun mapFromDB(rowSet: QueryRowSet): Producto {
        return Producto(rowSet[Productos.codProducto],rowSet[Productos.precioPesos]?.toDouble(),rowSet[Productos.precioDolar]?.toDouble(),rowSet[Productos.nombre])
    }
}