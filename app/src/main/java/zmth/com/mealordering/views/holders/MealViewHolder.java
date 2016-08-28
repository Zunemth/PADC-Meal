package zmth.com.mealordering.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import zmth.com.mealordering.R;
import zmth.com.mealordering.data.vos.Meal;


/**
 * Created by zmth on 8/21/16.
 */
public class MealViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_meal_image)
    ImageView ivMealImage;

    @BindView(R.id.tv_meal_name)
    TextView tvMealName;

    public MealViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    public void setData(Meal meal) {

        tvMealName.setText(meal.getName());

        Glide.with(ivMealImage.getContext())
                .load(meal.getImgUrl())
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher)
                .into(ivMealImage);

    }


}
