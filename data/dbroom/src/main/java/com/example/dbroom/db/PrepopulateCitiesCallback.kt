package com.example.dbroom.db

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.dbroom.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray

class PrepopulateCitiesCallback(private val context: Context): RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        CoroutineScope(Dispatchers.IO).launch {
            prepopulate(context)
        }
    }

    private fun prepopulate(context: Context) {
        try {
            println("nhbm prepopulate")

            val userList: JSONArray =
                context.resources.openRawResource(R.raw.cities).bufferedReader().use {
                    JSONArray(it.readText())
                }
            println("nhbm userListSize ${userList.length()} ")
            println("nhbm city at index 0 ${userList.getJSONObject(0).get("name")} ")

//            userList.takeIf { it.length() > 0 }?.let { list ->
//                for (index in 0 until list.length()) {
//                    val userObj = list.getJSONObject(index)
//                    userDao.insertUser(
//                        User(
//                            userObj.getInt("userId"),
//                            userObj.getString("userName")
//                        )
//                    )
//
//                }
//                Log.e("User App", "successfully pre-populated users into database")
//            }
        } catch (exception: Exception) {
            println(
                "User App" +
                exception.localizedMessage
            )
        }
    }
}