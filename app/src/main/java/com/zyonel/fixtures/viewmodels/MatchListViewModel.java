package com.zyonel.fixtures.viewmodels;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zyonel.fixtures.models.MatchResponse;
import com.zyonel.fixtures.repository.MatchRepository;

public class MatchListViewModel extends ViewModel {

    private MutableLiveData<MatchResponse> mutableLiveData;

    public void init(Application application){
        if (mutableLiveData != null){
            return;
        }
        MatchRepository matchRepository = MatchRepository.getInstance(application);
        mutableLiveData = matchRepository.getMatches();

    }

    public LiveData<MatchResponse> getMatchRepository() {
        return mutableLiveData;
    }
    
}
