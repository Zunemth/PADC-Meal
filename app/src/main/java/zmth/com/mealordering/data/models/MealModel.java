package zmth.com.mealordering.data.models;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import zmth.com.mealordering.data.agents.MealRetrofit;
import zmth.com.mealordering.data.vos.Meal;
import zmth.com.mealordering.events.MealListEvent;


/**
 * Created by zmth on 8/21/16.
 */
public class MealModel {

    private static MealModel objInstance;

    private List<Meal> mMealList;

    private MealModel() {
        MealRetrofit.getInstance().loadMealList();
        mMealList = new ArrayList<>();

    }

    public static MealModel getInstance() {
        if (objInstance == null) {
            objInstance = new MealModel();
        }
        return objInstance;
    }

    public List<Meal> getMealList() {
        return mMealList;
    }

    public void setMealList(List<Meal> mealList) {

        this.mMealList = mealList;
        EventBus.getDefault().post(new MealListEvent());

    }

    public void setMealError(String message) {
        Log.e("Meal Application", message);
    }
}
