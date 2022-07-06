package elchelomotos.com.ar.data.tables

import org.ktorm.schema.Table
import org.ktorm.schema.datetime
import org.ktorm.schema.int

object Ventas:Table<Nothing>("venta") {
    val idVenta = int("idVenta").primaryKey()
    val idCliente = int("idCliente")
    val fecha = datetime("fecha")
}