package zmth.com.mealordering.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zmth.com.mealordering.MealOrderingApp;
import zmth.com.mealordering.R;
import zmth.com.mealordering.adapters.MealAdapter;
import zmth.com.mealordering.data.models.MealModel;
import zmth.com.mealordering.data.vos.Meal;
import zmth.com.mealordering.events.MealListEvent;

/**
 * Created by zmth on 8/21/16.
 */

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @BindView(R.id.rv_meal)
    RecyclerView rvMeal;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private MealAdapter mAdapter;

    private List<Meal> mealList = new ArrayList<>();

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mealList = MealModel.getInstance().getMealList();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);

        mAdapter = new MealAdapter(mealList);
        rvMeal.setAdapter(mAdapter);
        rvMeal.setLayoutManager(new LinearLayoutManager(MealOrderingApp.getContext(), LinearLayoutManager.VERTICAL, false));

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
       EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    /*Load Data via network*/
    @Subscribe
    public void onDataLoaded(MealListEvent event) {
        swipeRefreshLayout.setRefreshing(false);
        mAdapter.setItems(MealModel.getInstance().getMealList());
    }

}
