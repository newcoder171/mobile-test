package com.zyonel.fixtures;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.zyonel.fixtures.adapters.MatchListAdapter;
import com.zyonel.fixtures.models.Match;
import com.zyonel.fixtures.models.MatchResponse;
import com.zyonel.fixtures.viewmodels.MatchListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MatchListViewModel mMatchListViewModel;
    private ListView mListView;
    private MatchListAdapter mAdapter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar myProgressBar= findViewById(R.id.progress_bar);
        myProgressBar.setIndeterminate(true);
        myProgressBar.setVisibility(View.VISIBLE);

        mMatchListViewModel = new ViewModelProvider(this).get(MatchListViewModel.class);


        mMatchListViewModel.init(getApplication());
        mMatchListViewModel.getMatchRepository().observe(this, response -> {
            populateListView(response.getMatches());
        });
    }

    private void populateListView(List<Match> matchList) {
        mListView = findViewById(R.id.list_notes);
        mAdapter = new MatchListAdapter(this, matchList);
        mListView.setAdapter(mAdapter);
    }
}
