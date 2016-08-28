package zmth.com.mealordering.data.agents;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import zmth.com.mealordering.responses.MealListResponse;
import zmth.com.mealordering.utils.MealOrderingConstants;


/**
 * Created by zmth on 8/21/16.
 */
public interface MealApi {

    @FormUrlEncoded
    @POST(MealOrderingConstants.API_GET_MEAL_LIST)
    Call<MealListResponse> loadMealList(
            @Field(MealOrderingConstants.PARAM_ACCESS_TOKEN) String param);

}
