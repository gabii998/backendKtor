package elchelomotos.com.ar.repositories

import elchelomotos.com.ar.core.DatabaseResult
import elchelomotos.com.ar.data.entities.Cliente

interface ClientRepository {
    fun getClientList():List<Cliente>
    fun insertClient(cliente: Cliente):DatabaseResult<Cliente>
}