package zmth.com.mealordering.utils;

import com.google.gson.Gson;

/**
 * Created by zmth on 8/21/16.
 */
public class CommonInstance {

    private static Gson gson = new Gson();

    public static Gson getGsonInstance(){
        return gson;
    }

}
