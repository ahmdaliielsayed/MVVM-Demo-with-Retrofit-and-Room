package com.example.kabaddi.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kabaddi.model.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INTSTANCE: ProductDatabase? = null

        fun getInstance(context: Context): ProductDatabase {
            return INTSTANCE ?: synchronized(this) {
                INTSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INTSTANCE = it
                    }
            }
        }
    }
}
