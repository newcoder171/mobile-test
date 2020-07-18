package com.zyonel.fixtures.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.zyonel.fixtures.database.AppDatabase;
import com.zyonel.fixtures.database.MatchDao;
import com.zyonel.fixtures.models.Match;
import com.zyonel.fixtures.models.MatchResponse;
import com.zyonel.fixtures.network.FixtureService;
import com.zyonel.fixtures.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchRepository {

    private String TAG = MatchRepository.class.getSimpleName();
    private static MatchRepository matchRepository;
    private MatchDao mMatchDao;

    public static MatchRepository getInstance(Application application) {
        if (matchRepository == null) {
            matchRepository = new MatchRepository(application);
        }
        return matchRepository;
    }

    private FixtureService mFixtureService;

    private MatchRepository(Application application) {
        mFixtureService = RetrofitClient.getRetrofitInstance().create(FixtureService.class);
        AppDatabase db = AppDatabase.getInstance(application);
        mMatchDao = db.matchDao();
    }

    public MutableLiveData<MatchResponse> getMatches() {
        final MutableLiveData<MatchResponse> matchResponse = new MutableLiveData<>();
        mFixtureService.getMatches().enqueue(new Callback<MatchResponse>() {
            @Override
            public void onResponse(Call<MatchResponse> call,
                                   Response<MatchResponse> response) {
                if (response.isSuccessful()) {
                    matchResponse.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MatchResponse> call, Throwable t) {
                Log.d(TAG, t.getMessage());
//                matchResponse.setValue(null);
            }
        });
        return matchResponse;
    }

    void insert(Match... matches) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mMatchDao.insertAll(matches);
        });
    }

}
