package news.in.pak.pakistannews.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import com.google.android.youtube.player.YouTubePlayerView;

import news.in.pak.pakistannews.R;

public class YoutubePlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static String youtubeId = "";
    private YouTubePlayerView mYouTubePlayerView;
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    public static final String LINK_INFO = "YoutubePlayerActivityLinkInfo";
    private static final String PLAYER_ERROR_UNKNOWN = "UNKNOWN"; // Error for those links which do not work in the Browser
    private static final String PLAYER_ERROR_NOT_PLAYABLE = "NOT_PLAYABLE"; // Error for those links which do not work in the Browser
    private static final String PLAYER_ERROR_INTERNAL_ERROR = "INTERNAL_ERROR"; // Error for those links which do work in the Browser
    private static final String DEVELOPER_KEY = "AIzaSyD5d2IJ8VfUXJ0mXUbKn-OJF2iDUhI9cX4";
    private MyPlayerStateChangeListener mPlayerStateChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_youtube_player);
        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        mYouTubePlayerView.initialize(DEVELOPER_KEY, this);
        mPlayerStateChangeListener = new MyPlayerStateChangeListener();

/*        //Prepare the Interstitial Ad
        final InterstitialAd interstitial = new InterstitialAd(YoutubePlayerActivity.this);
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

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        player.setPlayerStateChangeListener(mPlayerStateChangeListener);
        if (!wasRestored) {
            Intent intent = getIntent();
            if (intent.hasExtra(LINK_INFO)) {
                youtubeId = intent.getStringExtra(LINK_INFO);
                player.loadVideo(youtubeId);
                // Hiding player controls
                player.setPlayerStyle(PlayerStyle.CHROMELESS);
            }
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(getString(R.string.error_player), errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(DEVELOPER_KEY, this);
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_player_view);
    }

    private final class MyPlayerStateChangeListener implements YouTubePlayer.PlayerStateChangeListener {

        @Override
        public void onLoading() {
            // Called when the player is loading a video
            // At this point, it's not ready to accept commands affecting playback such as play() or pause()
//            Toast.makeText(YoutubePlayerActivity.this, "Video Loading", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLoaded(String s) {
            // Called when a video is done loading.
            // Playback methods such as play(), pause() or seekToMillis(int) may be called after this callback.
//            Toast.makeText(YoutubePlayerActivity.this, "Video loaded\n" + s, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdStarted() {
            // Called when playback of an advertisement starts.
//            Toast.makeText(YoutubePlayerActivity.this, "Ad started", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onVideoStarted() {
            // Called when playback of the video starts.
//            Toast.makeText(YoutubePlayerActivity.this, "Video started", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onVideoEnded() {
            // Called when the video reaches its end.
//            Toast.makeText(YoutubePlayerActivity.this, "Video ended", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {
            String errorString = errorReason.toString();
            /*if ((errorString.equalsIgnoreCase(PLAYER_ERROR_INTERNAL_ERROR)) || (errorString.equalsIgnoreCase(PLAYER_ERROR_NOT_PLAYABLE))) {
                Intent intent = new Intent(YoutubePlayerActivity.this, WebViewActivity.class);
                intent.putExtra(WebViewActivity.LINK_INFO, youtubeId);
                startActivity(intent);
                finish();
            }*/
            finish();
            Toast.makeText(YoutubePlayerActivity.this, errorString, Toast.LENGTH_SHORT).show();
        }
    }
}
