package news.in.pak.pakistannews.Additional;


import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;

/**
 * Created by Husnain Iqnal on 04-Jun-17.
 */
public class AppConfigurations {
    public static void setActionbarAndPrevButton(AppCompatActivity compatActivity, Toolbar toolbar){
        compatActivity.setSupportActionBar(toolbar);
        // add back arrow to toolbar
        ActionBar actionBar = compatActivity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    public static int getScreenOrientation(Activity activity){
        return activity.getResources().getConfiguration().orientation;
    }

    public static void getScreenOrientationAndSetToolbarVisibility(Activity activity, Toolbar toolbar){
        if (getScreenOrientation(activity) == Configuration.ORIENTATION_LANDSCAPE) {
            toolbar.setVisibility(View.GONE);
        }
        else {
            toolbar.setVisibility(View.VISIBLE);
        }
    }

    public static void getScreenOrientationAndSetToolbarVisibility(Activity activity, android.widget.Toolbar toolbar){
        if (getScreenOrientation(activity) == Configuration.ORIENTATION_LANDSCAPE) {
            toolbar.setVisibility(View.GONE);
        }
        else {
            toolbar.setVisibility(View.VISIBLE);
        }
    }

    public static ScreenDimensions getScreenDimensions(Activity activity){
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return new ScreenDimensions(size.x, size.y);
    }


    public static String validateThumbnailUrl(String thumbnailUrl){
        if (thumbnailUrl.endsWith(".png") || thumbnailUrl.endsWith(".PNG")) {
            return thumbnailUrl;
        }
        else {
            if (thumbnailUrl.endsWith(".gif")) {
                thumbnailUrl = thumbnailUrl.replace(".gif", ".png");
            }
            else if (thumbnailUrl.endsWith(".GIF")) {
                thumbnailUrl = thumbnailUrl.replace(".GIF", ".png");
            }
            else if (thumbnailUrl.endsWith(".JPEG")) {
                thumbnailUrl = thumbnailUrl.replace(".JPEG", ".png");
            }
            else if (thumbnailUrl.endsWith(".jpeg")) {
                thumbnailUrl = thumbnailUrl.replace(".jpeg", ".png");
            }
            return thumbnailUrl;
        }
    }

}
