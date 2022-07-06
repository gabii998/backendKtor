package elchelomotos.com.ar.data.tables

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Parametros:Table<Nothing>("parametros") {
    val id = int("id").primaryKey()
    val margen = varchar("magen")
    val precioDolar = varchar("precioDolar")
}