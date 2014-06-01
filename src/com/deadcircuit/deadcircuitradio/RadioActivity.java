package com.deadcircuit.deadcircuitradio;

import java.io.IOException;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

public class RadioActivity extends Activity
    implements MediaPlayer.OnPreparedListener
{

  private MediaPlayer mediaPlayer;

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
    mediaPlayer = new MediaPlayer();
    try
    {
      mediaPlayer.reset();
      mediaPlayer.setDataSource(this, uri);
      mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
      mediaPlayer.setOnPreparedListener(this);
      mediaPlayer.prepareAsync();
    }
    catch (IOException e)
    {
      e.printStackTrace(); //To change body of catch statement use File | Settings | File Templates.
    }
    /*
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.start();
    */
  }

  /**
   * Called when the media file is ready for playback.
   *
   * @param mediaPlayer the MediaPlayer that is ready for playback
   */
  @Override
  public void onPrepared(MediaPlayer mediaPlayer)
  {
    mediaPlayer.start();
  }
}
