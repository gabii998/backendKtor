package elchelomotos.com.ar.data.entities

import org.ktorm.dsl.QueryRowSet

abstract class Entity<T> {
    abstract fun mapFromDB(rowSet:QueryRowSet):T
}