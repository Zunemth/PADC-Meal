package zmth.com.mealordering.data.agents;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zmth.com.mealordering.data.models.MealModel;
import zmth.com.mealordering.responses.MealListResponse;
import zmth.com.mealordering.utils.CommonInstance;
import zmth.com.mealordering.utils.MealOrderingConstants;


/**
 * Created by zmth on 8/21/16.
 */
public class MealRetrofit implements DataAgents {

    private static MealRetrofit objInstance;

    private final MealApi theApi;

    private MealRetrofit() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MealOrderingConstants.MEAL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(CommonInstance.getGsonInstance()))
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(MealApi.class);

    }

    public static MealRetrofit getInstance() {

        if (objInstance == null) {
            objInstance = new MealRetrofit();
        }


        return objInstance;
    }


    @Override
    public void loadMealList() {
        final Call<MealListResponse> mealListResponseCall = theApi.loadMealList(MealOrderingConstants.ACCESS_TOKEN);
        mealListResponseCall.enqueue(new Callback<MealListResponse>() {
            @Override
            public void onResponse(Call<MealListResponse> call, Response<MealListResponse> response) {
                MealListResponse mealListResponse = response.body();h
                MealModel.getInstance().setMealList(mealListResponse.getMealList());
            }

            @Override
            public void onFailure(Call<MealListResponse> call, Throwable t) {
                MealModel.getInstance().setMealError(t.getMessage());
            }
        });
    }
}
