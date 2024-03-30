package util

import java.io.FileInputStream
import java.io.IOException
import java.util.*

object ConfProperties {

    private var fileInputStream: FileInputStream? = null
    private var PROPERTIES: Properties? = null

    init {
        try {
            fileInputStream = FileInputStream("src/test/resources/conf.properties")
            PROPERTIES = Properties()
            PROPERTIES!!.load(fileInputStream)
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (fileInputStream != null) try {
                fileInputStream!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    fun getProperty(key: String?): String {
        return PROPERTIES!!.getProperty(key)
    }
}