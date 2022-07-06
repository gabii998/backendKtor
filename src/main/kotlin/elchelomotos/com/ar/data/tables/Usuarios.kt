package elchelomotos.com.ar.data.tables

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Usuarios:Table<Nothing>("usuarios") {
    val idUsuario = int("idUsuarios").primaryKey()
    val usuario = varchar("usuario")
    val password = varchar("password")
}