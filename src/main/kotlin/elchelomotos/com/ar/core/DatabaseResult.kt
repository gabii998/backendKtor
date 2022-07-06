package elchelomotos.com.ar.core

data class DatabaseResult<T>(val data:T?=null,val message:String?,val success:Boolean)