package news.in.pak.pakistannews.Activities;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import news.in.pak.pakistannews.Additional.AppConfigurations;
import news.in.pak.pakistannews.Additional.ChannelInfo;
import news.in.pak.pakistannews.Adapters.MainAdapter;
import news.in.pak.pakistannews.Additional.ScreenDimensions;
import news.in.pak.pakistannews.R;
import news.in.pak.pakistannews.Additional.Utilities;

public class MainActivity extends AppCompatActivity implements MainAdapter.SendData {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.action_bar);
        }

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");

        GridView gridView = (GridView) findViewById(R.id.gridView_main);
        ArrayList<ChannelInfo> channelRecord = getChannelRecord();
        MainAdapter adapter = new MainAdapter(MainActivity.this, MainActivity.this, channelRecord);
        gridView.setAdapter(adapter);
        if (AppConfigurations.getScreenOrientation(MainActivity.this) == Configuration.ORIENTATION_LANDSCAPE) {
            gridView.setNumColumns(4);
        }
//        AdView adView = (AdView)findViewById(R.id.banner_ad_view_main);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);
    }

    private ArrayList<ChannelInfo> getChannelRecord() {
        ArrayList<ChannelInfo> channelList = new ArrayList<>();
        channelList.add(new ChannelInfo(Utilities.GEO_NEWS_NAME, Utilities.getGeoNewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.SAMAA_NEWS_NAME, Utilities.getSamaaNewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.GNN_NEWS_NAME, Utilities.getGNNChannelList()));
        channelList.add(new ChannelInfo(Utilities.AAJ_NEWS_NAME, Utilities.getAajNewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.PTV_NEWS_NAME, Utilities.getPtvNewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.EXPRESS_NEWS_NAME, Utilities.getExpressNewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.ARY_NEWS_NAME, Utilities.getAryNewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.DUNYA_NEWS_NAME, Utilities.getDunyaNewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.BOL_TV_NAME, Utilities.getBolNewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.NINETY_TWO_NEWS_NAME, Utilities.getNinetyTwoNewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.PUBLIC_CHANNEL_NAME, Utilities.getPublicNewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.HUM_CHANNEL_NAME, Utilities.getHumNewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.DIN_CHANNEL_NAME, Utilities.getDinNewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.TWENTY_FOUR_CHANNEL_NAME, Utilities.getTwentyFourNewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.C41_CHANNEL_NAME, Utilities.getC41NewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.C42_CHANNEL_NAME, Utilities.getC42NewsChannelList()));
        channelList.add(new ChannelInfo(Utilities.LAHORE_NEWS_NAME, Utilities.getLahoreNewsChannelList()));

        return channelList;
    }

    @Override
    public void sendData2NewScreen(ChannelInfo channelInfo) {
        ArrayList<String> channelUrlList = channelInfo.getUrlList();
        if (channelUrlList.size() == 1) {
            //TODO: Go to YoutubeActivity
            Intent intent = new Intent(MainActivity.this, YoutubePlayerActivity.class);
            intent.putExtra(YoutubePlayerActivity.LINK_INFO, channelUrlList.get(0));
            startActivity(intent);
        } else {
            //TODO: GO to ChannelListActivity
            Intent intent = new Intent(MainActivity.this, ChannelListActivity.class);
            intent.putExtra(ChannelListActivity.SERIALIZABLE_OBJECT_INFO_TEXT, channelInfo);
            startActivity(intent);
        }
    }

//    @Override
//    public void sendData2NewScreen(ChannelInfo channelInfo){
//        Intent intent = new Intent(MainActivity.this, YoutubePlayerActivity.class);
//        intent.putExtra(YoutubePlayerActivity.LINK_INFO, channelInfo.getLink());
//        startActivity(intent);
//    }
}
