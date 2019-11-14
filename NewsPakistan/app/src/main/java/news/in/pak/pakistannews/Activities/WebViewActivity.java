package news.in.pak.pakistannews.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import news.in.pak.pakistannews.R;

public class WebViewActivity extends AppCompatActivity {
    public static final String LINK_INFO = "WebViewActivityLinkInfo";
    private static final String YOUTUBE_FULL_SCREEN_LINK = "https://www.youtube.com/embed/";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView mWebView = (WebView)findViewById(R.id.web_view);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        Intent intent = getIntent();
        if (intent.hasExtra(LINK_INFO)) {
            String youtubeVideoId = intent.getStringExtra(LINK_INFO);
            mWebView.loadUrl(YOUTUBE_FULL_SCREEN_LINK + youtubeVideoId);
        }

/*                //Prepare the Interstitial Ad
        final InterstitialAd interstitial = new InterstitialAd(WebViewActivity.this);
        //Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitial.loadAd(adRequest);
        //Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded(){
                //If Ads are loaded, show Interstitial else show nothing.
                if (interstitial.isLoaded()) {
                    interstitial.show();
                }
            }
        });*/
    }
}
