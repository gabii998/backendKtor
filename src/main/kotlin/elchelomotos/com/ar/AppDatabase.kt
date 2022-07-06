package elchelomotos.com.ar

import org.ktorm.database.Database

object AppDatabase {

    fun getDatabase():Database{
        return Database.connect(
            url = "jdbc:mysql://localhost:3306/motos",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = ""
        )
    }
}