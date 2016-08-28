package zmth.com.mealordering;

import android.app.Application;
import android.content.Context;

/**
 * Created by zmth on 8/21/16.
 */
public class MealOrderingApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
