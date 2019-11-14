package news.in.pak.pakistannews.Adapters;


import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import news.in.pak.pakistannews.Additional.ChannelInfo;
import news.in.pak.pakistannews.R;
import news.in.pak.pakistannews.Additional.Utilities;

/**
 * Created by hp on 3/20/2017.
 */

public class ChannelListAdapter extends BaseAdapter {
    private Activity mActivity;
    //    private Context mContext;
//    private SendData mSendData;
    private LayoutInflater mLayoutInflater;
    private String mChannelName;
    private ArrayList <String> mChannelUrlList;

    public ChannelListAdapter(SendData sendData, Activity activity, ChannelInfo channelInfo){
        mActivity = activity;
//        mContext = mActivity.getApplicationContext();
//        mSendData = sendData;
        mChannelName = channelInfo.getName();
        mChannelUrlList = channelInfo.getUrlList();
        mLayoutInflater = LayoutInflater.from(activity.getApplicationContext());
    }

    @Override
    public int getCount(){
        return mChannelUrlList.size();
    }

    @Override
    public Object getItem(int position){
        return mChannelUrlList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent){
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.adapter_layout_channel_list, parent, false);
            holder = new ViewHolder();
            holder.imageView = (ImageView)view.findViewById(R.id.item_imageView);
            holder.textView = (TextView)view.findViewById(R.id.item_textView);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder)view.getTag();
        }

//        holder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v){
//                mSendData.sendData2NewScreen(mChannelUrlList.get(position));
//            }
//        });
//        holder.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v){
//                mSendData.sendData2NewScreen(mChannelUrlList.get(position));
//            }
//        });
        holder.textView.setText(mChannelName + " (Link " + (position+1) + ")");
        Drawable drawable = getChannelImageDrawable(mChannelName);
        holder.imageView.setImageDrawable(drawable);
        return view;
    }

    private Drawable getChannelImageDrawable(String channelName){
        Drawable drawable;
        switch (channelName) {
            case Utilities.AAJ_NEWS_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.aaj_logo2);
                break;
            case Utilities.ARY_NEWS_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.ary_logo2);
                break;
            case Utilities.BOL_TV_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.bol_logo2);
                break;
            case Utilities.DUNYA_NEWS_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.dunya_logo2);
                break;
            case Utilities.EXPRESS_NEWS_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.express_logo2);
                break;
            case Utilities.GEO_NEWS_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.geo_logo2);
                break;
            case Utilities.LAHORE_NEWS_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.lahore_logo2);
                break;
            case Utilities.NINETY_TWO_NEWS_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.ninety_two_logo2);
                break;
            case Utilities.PTV_NEWS_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.ptv_logo2);
                break;
            case Utilities.SAMAA_NEWS_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.samaa_logo2);
                break;
            case Utilities.TWENTY_FOUR_CHANNEL_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.twenty_four_logo2);
                break;
            default:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.default_icon);
                break;
        }
        return drawable;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }


    public interface SendData {
        void sendData2NewScreen(String channelUrl);
    }
}
