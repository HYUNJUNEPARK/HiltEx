package com.aos.hiltex.example2.db

import android.content.Context
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import com.aos.hiltex.example2.db.AppDatabase.Companion.DB_NAME

@Database(entities = [Memo::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun memoDao(): MemoDao

    companion object {
        const val DB_NAME = "myDB"
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(AppDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DB_NAME
                    ).build()
                }
            }
            return instance!!
        }
    }
}

@Entity(tableName = DB_NAME)
data class Memo(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo
    var content: String,

    @ColumnInfo(name = "date")
    var dateTime: Long
)

@Dao
interface MemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(memo: Memo)

    @Query("SELECT * FROM $DB_NAME")
    fun getAll(): List<Memo>

    @Query("SELECT content FROM $DB_NAME WHERE id = :no")
    fun getMemo(no:Int): String

    @Update
    fun update(memo: Memo)

    @Delete
    fun delete(memo: Memo)
}