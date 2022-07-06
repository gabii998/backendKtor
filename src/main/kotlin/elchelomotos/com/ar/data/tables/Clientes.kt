package elchelomotos.com.ar.data.tables

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Clientes:Table<Nothing>("clientes") {
    val id = int("id").primaryKey()
    val nombre = varchar("nombre")
    val apellido = varchar("apellido")
    val telefono = varchar("telefono")
    val mail = varchar("email")
}