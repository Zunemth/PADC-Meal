package zmth.com.mealordering.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zmth.com.mealordering.MealOrderingApp;
import zmth.com.mealordering.R;
import zmth.com.mealordering.data.vos.Meal;
import zmth.com.mealordering.views.holders.MealViewHolder;


/**
 * Created by zmth on 8/21/16.
 */
public class MealAdapter extends RecyclerView.Adapter<MealViewHolder> {

    private LayoutInflater inflater;
    private List<Meal> mealList = new ArrayList<>();


    public MealAdapter(List<Meal> mealList) {
        inflater = LayoutInflater.from(MealOrderingApp.getContext());
        this.mealList = mealList;

    }

    public void setItems(List<Meal> mealList) {
        this.mealList = mealList;
        notifyDataSetChanged();
    }

    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.meal_card_item,parent,false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MealViewHolder holder, int position) {
        holder.setData(mealList.get(position));
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }
}
