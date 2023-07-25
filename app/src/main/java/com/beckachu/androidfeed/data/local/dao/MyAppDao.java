package com.beckachu.androidfeed.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.beckachu.androidfeed.data.entities.MyAppEntity;

import java.util.List;


@Dao
public interface MyAppDao {
    // Get apps list, name ascending
    @Query("SELECT * FROM myappentity ORDER BY appName ASC")
    List<MyAppEntity> getAllByNameAsc();

    // Insert an app
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    boolean insertApp(MyAppEntity myAppEntity);

    // Set app's favorite preference
    @Query("UPDATE myappentity SET isFavorite = :pref WHERE packageName = :packageName")
    boolean setFavorite(String packageName, boolean pref);

    // Set app's noti preference
    @Query("UPDATE myappentity SET isReceivingNoti = :pref WHERE packageName = :packageName")
    boolean setReceiveNoti(String packageName, boolean pref);
}