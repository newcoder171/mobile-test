package com.zyonel.fixtures.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zyonel.fixtures.R;
import com.zyonel.fixtures.models.Match;
import com.zyonel.fixtures.utils.DateUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MatchListAdapter extends ArrayAdapter<Match> {

    private Context mContext;
    private List<Match> matchList = new ArrayList<>();

    public MatchListAdapter(@NonNull Context context, @NonNull List<Match> matchList) {
        super(context, 0, matchList);
        mContext = context;
        this.matchList = matchList;
    }

    @NonNull
        @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_row,parent,false);
        }
        Match match = matchList.get(position);

        TextView teamOne = convertView.findViewById(R.id.team_one);
        teamOne.setText(match.getHomeTeam().getName());

        TextView teamTwo = convertView.findViewById(R.id.team_two);
        teamTwo.setText(match.getAwayTeam().getName());

        TextView matchTimeText = convertView.findViewById(R.id.game_time);
        matchTimeText.setText(DateUtil.convertToLocalDateTimeViaInstant(match.getUtcDate()));

        TextView matchDay = convertView.findViewById(R.id.match_day);
        matchDay.setText(String.format("MD %d", match.getMatchday()));



        return convertView;
    }
}
