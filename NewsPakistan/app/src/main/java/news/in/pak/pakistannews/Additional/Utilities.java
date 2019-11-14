package news.in.pak.pakistannews.Additional;


import java.util.ArrayList;

/**
 * Created by Husnain Iqbal on 8/9/2017.
 */

public class Utilities {
    public static final String AAJ_NEWS_NAME = "آج نیوز"; //"Aaj News";
    public static final String ARY_NEWS_NAME = "اے آر واے نیوز";//"ARY News";
    public static final String DUNYA_NEWS_NAME = "دنیا نیوز";//"Dunya News";
    public static final String BOL_TV_NAME = "بول ٹی وی";//"BOL TV";
    public static final String PTV_NEWS_NAME = "پی ٹی وی نیوز";//"PTV News";
    public static final String GEO_NEWS_NAME = "جیو نیوز";//"Geo News";
    public static final String SAMAA_NEWS_NAME = "سماء نیوز";//"SAMAA TV";
    public static final String GNN_NEWS_NAME = "جی این این";//"GNN TV";
    public static final String LAHORE_NEWS_NAME = "لاہور نیوز";//"Lahore News";
    public static final String EXPRESS_NEWS_NAME = "ایکسپریس نیوز";//"Express News";
    public static final String NINETY_TWO_NEWS_NAME = "٩٢ نیوز";//"Live 92 News";
    public static final String NINETY_TWO_NEWS_UK_NAME = "٩٢ نیوز انگلینڈ";//"Live 92 News UK";
    public static final String TWENTY_FOUR_CHANNEL_NAME = "٢٤ نیوز";//"24 News";
    public static final String C42_CHANNEL_NAME = "سٹی ٤٢";//"City42 News";
    public static final String C41_CHANNEL_NAME = "سٹی ٤١";//"City41 News";
    public static final String PUBLIC_CHANNEL_NAME = "پبلک نیوز";//"Public News";
    public static final String HUM_CHANNEL_NAME = "ہم نیوز";//"HUM News";
    public static final String DIN_CHANNEL_NAME = "دن نیوز";//"DIN News";

    private static final String GEO_NEWS_YOUTUBE_LINK_ID = "EnhsuKxK_Uk";
    private static final String DUNYA_NEWS_YOUTUBE_LINK_ID = "#";
    private static final String AAJ_NEWS_YOUTUBE_LINK_ID = "vdejK2Sq_VY";
    private static final String PTV_NEWS_YOUTUBE_LINK_ID = "#";
    private static final String EXPRESS_NEWS_YOUTUBE_LINK_ID = "68wxdDeVlJY";
    private static final String SAMAA_TV_YOUTUBE_LINK_ID = "s0mGJZ_89iE";
    private static final String GNN_YOUTUBE_LINK_ID = "5G6F8cVGoGw";
    private static final String ARY_NEWS_YOUTUBE_LINK_ID = "veRirYqQZyo";
    private static final String BOL_TV_YOUTUBE_LINK_ID = "mUyCL-orEc0";
    private static final String NINETY_TWO_NEWS_YOUTUBE_LINK_ID= "5p88VTsACz8";
    private static final String TWENTY_FOUR_CHANNEL_NEWS_YOUTUBE_LINK_ID = "#";
    private static final String C42_NEWS_YOUTUBE_LINK_ID = "#";
    private static final String C41_NEWS_YOUTUBE_LINK_ID = "MOzKjmcQrFM";
    private static final String LAHORE_NEWS_YOUTUBE_LINK_ID = "BElALZf1af4";
    private static final String DIN_NEWS_YOUTUBE_LINK_ID = "xfJaf4VzoCc";
    private static final String HUM_NEWS_YOUTUBE_LINK_ID = "F-aoNz_rbSA";
    private static final String PUBLIC_NEWS_YOUTUBE_LINK_ID = "VFsZyn2_Pm4";

    public static ArrayList<String> getGeoNewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(GEO_NEWS_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getDunyaNewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(DUNYA_NEWS_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getAajNewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(AAJ_NEWS_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getPtvNewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(PTV_NEWS_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getExpressNewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(EXPRESS_NEWS_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getSamaaNewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(SAMAA_TV_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getGNNChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(GNN_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getAryNewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(ARY_NEWS_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getBolNewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(BOL_TV_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getNinetyTwoNewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(NINETY_TWO_NEWS_YOUTUBE_LINK_ID);
//        list.add(NINETY_TWO_NEWS_UK_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getTwentyFourNewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(TWENTY_FOUR_CHANNEL_NEWS_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getC42NewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(C42_NEWS_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getC41NewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(C41_NEWS_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getLahoreNewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(LAHORE_NEWS_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getDinNewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(DIN_NEWS_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getHumNewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(HUM_NEWS_YOUTUBE_LINK_ID);
        return list;
    }

    public static ArrayList<String> getPublicNewsChannelList(){
        ArrayList<String> list = new ArrayList <>();
        list.add(PUBLIC_NEWS_YOUTUBE_LINK_ID);
        return list;
    }
}
