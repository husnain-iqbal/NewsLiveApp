package news.in.pak.pakistannews.Adapters;


import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import news.in.pak.pakistannews.Additional.AppConfigurations;
import news.in.pak.pakistannews.Additional.ChannelInfo;
import news.in.pak.pakistannews.R;
import news.in.pak.pakistannews.Additional.ScreenDimensions;
import news.in.pak.pakistannews.Additional.Utilities;

/**
 * Created by hp on 3/20/2017.
 */

public class MainAdapter extends BaseAdapter {
    private Activity mActivity;
    private Context mContext;
    private SendData mSendData;
    private LayoutInflater mLayoutInflater;
    private ArrayList <ChannelInfo> mChannelList;

    public MainAdapter(SendData sendData, Activity activity, ArrayList <ChannelInfo> list){
        mActivity = activity;
        mContext = mActivity.getApplicationContext();
        mSendData = sendData;
        mChannelList = list;
        mLayoutInflater = LayoutInflater.from(activity.getApplicationContext());
    }

    @Override
    public int getCount(){
        return mChannelList.size();
    }

    @Override
    public Object getItem(int position){
        return mChannelList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent){
        View view = convertView;
        final ViewHolder holder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.adapter_layout_main, parent, false);
            holder = new ViewHolder();
            holder.imageView = (ImageView)view.findViewById(R.id.listview_row);
            holder.textView = (TextView)view.findViewById(R.id.imageView_text);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder)view.getTag();
        }

        ScreenDimensions screenDimensions = AppConfigurations.getScreenDimensions(mActivity);
        int screenWidth = screenDimensions.getWidth();
        int screenHeight = screenDimensions.getHeight();
        int screenOrientation = AppConfigurations.getScreenOrientation(mActivity);
        int specifiedHeight = screenHeight / 3;
        if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            specifiedHeight = screenHeight / 2;
        }
        holder.imageView.setMinimumHeight(specifiedHeight);
        holder.imageView.setMaxHeight(specifiedHeight);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mSendData.sendData2NewScreen(mChannelList.get(position));
            }
        });
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mSendData.sendData2NewScreen(mChannelList.get(position));
            }
        });
        ChannelInfo info = mChannelList.get(position);
        String channelName = info.getName();
        holder.textView.setText(channelName);
        Drawable drawable = getChannelImage(channelName);
        holder.imageView.setImageDrawable(drawable);
/*        String thumbnailUrl = info.getLink();
        if (thumbnailUrl != null && !thumbnailUrl.equals("")) {
            thumbnailUrl = AppConfigurations.validateThumbnailUrl(thumbnailUrl);
            Target target = new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    holder.imageView.setBackgroundColor(mContext.getResources().getColor(R.color.white));
                    holder.imageView.setImageBitmap(bitmap);
                }

                @Override
                public void onBitmapFailed(Drawable errorDrawable) {
//                    holder.imageView.setImageDrawable(errorDrawable);
                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {
//                e    holder.imageView.setImageDrawable(placeHolderDrawable);
                }
            };
            Picasso.with(mContext)
                    .load(thumbnailUrl)
                    .error(R.drawable.list_image)
                    .placeholder(R.drawable.list_image)
                    .resize(screenWidth, specifiedHeight)
                    .into(target);
        }*/
        return view;
    }

    private Drawable getChannelImage(String channelName){
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
            case Utilities.NINETY_TWO_NEWS_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.ninety_two_logo2);
                break;
            case Utilities.NINETY_TWO_NEWS_UK_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.ninety_two_logo2);
                break;
            case Utilities.PTV_NEWS_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.ptv_logo2);
                break;
            case Utilities.SAMAA_NEWS_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.samaa_logo2);
                break;
            case Utilities.GNN_NEWS_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.gnn_logo2);
                break;
            case Utilities.TWENTY_FOUR_CHANNEL_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.twenty_four_logo2);
                break;
            case Utilities.C41_CHANNEL_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.c41_logo2);
                break;
            case Utilities.C42_CHANNEL_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.c42_logo2);
                break;
            case Utilities.LAHORE_NEWS_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.lahore_logo2);
                break;
            case Utilities.PUBLIC_CHANNEL_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.public_logo2);
                break;
            case Utilities.HUM_CHANNEL_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.hum_logo2);
                break;
            case Utilities.DIN_CHANNEL_NAME:
                drawable = ContextCompat.getDrawable(mActivity, R.mipmap.din_logo2);
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
        void sendData2NewScreen(ChannelInfo ChannelInfo);
    }
}
