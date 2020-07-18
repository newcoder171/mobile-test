package com.zyonel.fixtures.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.zyonel.fixtures.models.Match;

import java.util.List;

@Dao
public interface MatchDao {

    @Query("SELECT * FROM matches")
    LiveData<List<Match>> getAll();

    @Insert
    void insertAll(Match... matches);

}
