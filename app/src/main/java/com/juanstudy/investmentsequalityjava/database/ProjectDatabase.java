package com.juanstudy.investmentsequalityjava.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.juanstudy.investmentsequalityjava.MainActivity;
import com.juanstudy.investmentsequalityjava.Models.Asset;
import com.juanstudy.investmentsequalityjava.dao.AssetDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Asset.class, version = 1, exportSchema = false)
public abstract class ProjectDatabase extends RoomDatabase {

    private static final String DB_NAME = "investments_database";
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static ProjectDatabase INSTANCE;

    public static synchronized ProjectDatabase getDatabase() {
        synchronized (ProjectDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(MainActivity.getMainActivity(), ProjectDatabase.class, DB_NAME).build();
            }
        }
        return INSTANCE;
    }

    public abstract AssetDao assetDao();
}
