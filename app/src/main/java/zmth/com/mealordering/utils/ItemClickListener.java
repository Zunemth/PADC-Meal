package zmth.com.mealordering.utils;

import android.widget.ImageView;

import zmth.com.mealordering.data.vos.Meal;


/**
 * Created by zmth on 8/18/16.
 */
public interface ItemClickListener {

    void onClick(Meal meal, ImageView ivMealImage);

}
