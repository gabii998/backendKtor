package elchelomotos.com.ar.data.tables

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object ProductoVenta:Table<Nothing>("productoventa") {
    val idProdVenta = int("idProdVenta")
    val codProducto = varchar("codProducto")
    val idVenta = int("idVenta")
    val precio = varchar("precio")
}