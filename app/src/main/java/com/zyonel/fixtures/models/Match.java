package com.zyonel.fixtures.models;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.zyonel.fixtures.utils.DateConverter;

import java.util.Date;

@Entity(tableName = "matches")
public class Match {

    @PrimaryKey
    private Integer id;

//    @ColumnInfo(name = "home_team")
    @Embedded(prefix = "home_team")
    private Team homeTeam;

//    @ColumnInfo(name = "away_team")
    @Embedded(prefix = "away_team")
    private Team awayTeam;

    @ColumnInfo(name = "match_day")
    private Integer matchday;

    @ColumnInfo(name = "game_time")
    @TypeConverters(DateConverter.class)
    private Date utcDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    public Date getUtcDate() {
        return utcDate;
    }

    public void setUtcDate(Date utcDate) {
        this.utcDate = utcDate;
    }
}
