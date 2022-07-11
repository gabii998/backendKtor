package elchelomotos.com.ar.repositories

import elchelomotos.com.ar.data.entities.Producto

interface ProductRepository {

    fun getProductos(limit:String?,offset:String?):List<Producto>
}