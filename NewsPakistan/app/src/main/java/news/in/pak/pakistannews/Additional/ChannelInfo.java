package news.in.pak.pakistannews.Additional;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Husnain Iqbal on 8/9/2017.
 */

public class ChannelInfo implements Serializable{

    private String mName;
    private ArrayList<String> mUrlList;

    public ChannelInfo(String name, ArrayList<String> urlList){
        mName = name;
        mUrlList = urlList;
    }

    public String getName(){
        return mName;
    }

    public ArrayList <String> getUrlList(){
        return mUrlList;
    }
}
