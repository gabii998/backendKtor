package elchelomotos.com.ar.core

/**
 * @param data: Carga util
 * @param message: Para enviar mensaje de error, en caso de ser necesario
 */
data class CustomResponse<T>(val data:T,val message:String?=null)