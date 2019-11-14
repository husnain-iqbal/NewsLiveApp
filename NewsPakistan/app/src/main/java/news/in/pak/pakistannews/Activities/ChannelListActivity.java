package news.in.pak.pakistannews.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import news.in.pak.pakistannews.Additional.ChannelInfo;
import news.in.pak.pakistannews.Adapters.ChannelListAdapter;
import news.in.pak.pakistannews.R;

public class ChannelListActivity extends AppCompatActivity implements ChannelListAdapter.SendData {
    public static final String SERIALIZABLE_OBJECT_INFO_TEXT = "ChannelListActivitySerializableInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_list);
        ListView listView = (ListView)findViewById(R.id.channelListView);
//        AdView mAdView = (AdView)findViewById(R.id.banner_ad_view_channelList);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        Intent intent = getIntent();
        final ChannelInfo info = (ChannelInfo)intent.getSerializableExtra(SERIALIZABLE_OBJECT_INFO_TEXT);
        if (info != null) {
            ChannelListAdapter adapter = new ChannelListAdapter(this, this, info);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView <?> adapterView, View view, int position, long l){
                    sendData2NewScreen(info.getUrlList().get(position));
                }
            });
        }
    }

    @Override
    public void sendData2NewScreen(String channelUrl){
        Intent intent = new Intent(ChannelListActivity.this, YoutubePlayerActivity.class);
        intent.putExtra(YoutubePlayerActivity.LINK_INFO, channelUrl);
//        Intent intent = new Intent(ChannelListActivity.this, WebViewActivity.class);
//        intent.putExtra(WebViewActivity.LINK_INFO, channelUrl);
        startActivity(intent);
    }
}
