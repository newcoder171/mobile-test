package com.zyonel.fixtures.models;

import java.util.ArrayList;

public class MatchResponse {
    private Integer count;
    private ArrayList<Match> matches;

    public MatchResponse(Integer count, ArrayList<Match> matches) {
        this.count = count;
        this.matches = matches;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }
}
