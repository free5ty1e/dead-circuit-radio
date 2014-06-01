package com.deadcircuit.deadcircuitradio;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class RadioActivity extends Activity
{
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    //Initialize the uri view with a shoutcast audio stream so that we can have mediacontroller controls for very little code
/*
    VideoView videoView = (VideoView) findViewById(R.id.video_view);
    MediaController mediaController = new MediaController(this);
    mediaController.setAnchorView(videoView);
*/
// Set uri link (mp4 format )
    Uri uri = Uri.parse(getString(R.string.shoutcast_stream_url));
    MediaPlayer mediaPlayer = new MediaPlayer();
    try {
      mediaPlayer.setDataSource(this, uri);
      mediaPlayer.prepare();
      mediaPlayer.start();
    } catch (IOException e) {
      e.printStackTrace(); //To change body of catch statement use File | Settings | File Templates.
    }
/*
    videoView.setMediaController(mediaController);
    videoView.setVideoURI(uri);
    videoView.start();
*/
  }
}
