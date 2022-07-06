package elchelomotos.com.ar.data.tables

import org.ktorm.schema.Table
import org.ktorm.schema.varchar

object Productos:Table<Nothing>("productos") {
    val codProducto = varchar("codProducto").primaryKey()
    val nombre = varchar("nombre")
    val precioPesos = varchar("precioPesos")
    val precioDolar = varchar("precioDolar")
}