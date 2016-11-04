package com.example.android.mp3player;

import android.accessibilityservice.AccessibilityService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Picture;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private String[] mPath;
    private String[] mMusic;
    private MediaPlayer mediaPlayer;
    ImageButton pausplay;
    ImageButton next;
    ImageButton prev;
    int songpos = 1;
    int songtime = 0;
    SeekBar seekBar;
    Handler handler = new Handler();
    TextView timeDur;
    TextView counttime;
    TextView nowplaying;;
    boolean pp = false;
    int durrr;
    int mins;
    int sec;
    String artist;
    String album;
    String track;
    boolean shuflist;
    String[] current;
    ToggleButton shuffle;
    ListAdapter listAdapter;
    private boolean ongoingCall = false;
    private PhoneStateListener phoneStateListener;
    private TelephonyManager telephonyManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Music Player ya Naz");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.myicon);

        CharSequence text = "app";
        Context context = null;

        Notification notification = new Notification(R.mipmap.myicon, text , System.currentTimeMillis());
        notification.flags |= Notification.FLAG_NO_CLEAR
                | Notification.FLAG_ONGOING_EVENT;

//        NotificationManager notifier = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
//        notifier.notify(1, notification);

        pausplay = (ImageButton) findViewById(R.id.pauseid);
        prev = (ImageButton)findViewById(R.id.backid);
        next = (ImageButton)findViewById(R.id.nxtid);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        timeDur = (TextView)findViewById(R.id.Idtime);
        counttime = (TextView) findViewById(R.id.IDcount);
        nowplaying = (TextView)findViewById(R.id.Idplaying);
        shuffle = (ToggleButton) findViewById(R.id.toggleButton);

        mediaPlayer = new MediaPlayer();
        mMusic = getAudioList();


        listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mMusic);
        final ListView listView = (ListView) findViewById(R.id.listview);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(listAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                songpos = i;
                 mPath = getmAudioPath();
             //   Toast.makeText(MainActivity.this,mPath[i],Toast.LENGTH_LONG).show();
                int len = 0;
                int k = 0;

                listView.clearChoices();

                try{


                    mediaPlayer.stop();
                    mediaPlayer.reset();

                    mediaPlayer.setDataSource(mPath[i]);//Write your location here
                    mediaPlayer.prepare();
                    mediaPlayer.setLooping(true);

                    mediaPlayer.start();
                    pausplay.setImageResource(R.drawable.ic_pause_black_24dp);

                    CountDownTimer timer;
                    mins = 0;
                    sec = 0;
                    timeDur.setText("" + mins +":" + sec);


//listView.getChildAt(i).setBackgroundColor(Color.GRAY);

                    pp = true;


                    MediaMetadataRetriever mmr = new MediaMetadataRetriever();
                    mmr.setDataSource(mPath[i]);

                    // Get the duration of the track
                    String durationText = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
                    int duration = Integer.parseInt(durationText);

                    // Get the title of the track
                    String title = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE );
                   // Picture picture = mmr.extractMetadata(M)
                //    Toast.makeText(MainActivity.this,title,Toast.LENGTH_SHORT).show();

                }catch(Exception e)
                {
                    e.printStackTrace();
                }


            }
        });


        shuffle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b)
                {
                    shuflist = true;
                }
                else
                {
                    shuflist = false;
                }
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int seeked_progess;
            int minute = 0;
            int secounds = 0;
            int max = seekBar.getMax();
            int legnth;


            @Override
            public void onProgressChanged(final SeekBar seekBar, int i, boolean b) {



                seeked_progess = seekBar.getProgress();
                durrr = seeked_progess;

                minute = (int) (seeked_progess / (60 * 1000));
                secounds = (int) ((seeked_progess / 1000) % 60);

                if(b)
                {
                    seeked_progess = seekBar.getProgress();
                    durrr = seeked_progess;

                    minute = (int) (seeked_progess / (60 * 1000));
                    secounds = (int) ((seeked_progess / 1000) % 60);

                }

                if(secounds < 10)
                {
                    counttime.setText(" /  "+minute+":0"+secounds);
                }
                else
                {
                    counttime.setText(" /  " + minute + ":" + secounds);
                }

                legnth = seeked_progess / 1000;




                if(minute == mins && secounds == sec)
                {
                    songpos++;
                    try{

                        //   mediaPlayer.stop();
                        mediaPlayer.reset();

                        mediaPlayer.setDataSource(mPath[songpos]);//Write your location here
                        mediaPlayer.prepare();
                        mediaPlayer.setLooping(true);
                        mediaPlayer.start();


                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                    mediaPlayer.seekTo(seeked_progess);
             //   seekBar.setProgress(seeked_progess);

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(shuflist == true)
                {
                    double randNumber = Math.random();
                    double d = randNumber * listView.getCount();
                    songpos = (int) d;
                }
                else
                {
                    songpos++;
                }

                try{

                 //   mediaPlayer.stop();
                    mediaPlayer.reset();

                    mediaPlayer.setDataSource(mPath[songpos]);//Write your location here
                    mediaPlayer.prepare();
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();



                    if(mediaPlayer.isPlaying())
                    {

                        MediaPlayer.TrackInfo[] songinfo = mediaPlayer.getTrackInfo();
                        String name = songinfo.toString();

                    }


                }catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
        });




        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    songpos--;
                    if(songpos == 0)
                    {
                        songpos = 1;
                    }

                    mediaPlayer.stop();
                    mediaPlayer.reset();

                    mediaPlayer.setDataSource(mPath[songpos]);//Write your location here
                    mediaPlayer.prepare();
                    mediaPlayer.setLooping(true);

                    mediaPlayer.start();

                    if(mediaPlayer.isPlaying())
                    {

                        MediaPlayer.TrackInfo[] songinfo = mediaPlayer.getTrackInfo();
                        String name = songinfo.toString();

                    }


                }catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
        });

        pausplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pausplay.setSelected(!pausplay.isSelected());
                if(pausplay.isSelected()) {
                    pausplay.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                   songtime = mediaPlayer.getCurrentPosition();

                    mediaPlayer.pause();

                }
                else
                {
                    pausplay.setImageResource(R.drawable.ic_pause_black_24dp);

                    mediaPlayer.start();

                    if(pp = false)
                    {

                        try {


                            mediaPlayer.setDataSource(mPath[1]);//Write your location here

                            mediaPlayer.prepare();
                            mediaPlayer.setLooping(true);

                            mediaPlayer.start();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }

            }
        });




        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(final MediaPlayer mediaPlayer)
            {
                seekBar.setMax(mediaPlayer.getDuration());
               final int dur = mediaPlayer.getDuration();
                sec = 0;

                int d = mediaPlayer.getCurrentPosition();
                mins = (int) (dur / (60 * 1000));
                sec = (int) ((dur / 1000) % 60);

                if(sec < 10)
                {
                    timeDur.setText(""+mins+":0"+ sec);
                }
                else
                {
                    timeDur.setText(""+mins+":"+ sec);
                }



                IntentFilter iF = new IntentFilter();
                iF.addAction("com.android.music.metachanged");
                iF.addAction("com.android.music.playstatechanged");
                iF.addAction("com.android.music.playbackcomplete");
                iF.addAction("com.android.music.queuechanged");


                registerReceiver(mReceiver,iF);

               nowplaying.setText("Now playing :"+mMusic[songpos]);



                new Thread(new Runnable()
                {

                    @Override
                    public void run()
                    {



                        while(mediaPlayer!=null && mediaPlayer.getCurrentPosition()<mediaPlayer.getDuration())
                        {

                          //  timeDur.setText(""+ sec);

                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {





                                    }
                            });


                            seekBar.setProgress(mediaPlayer.getCurrentPosition());
                            Message msg=new Message();
                            int millis = mediaPlayer.getCurrentPosition();

                            int rem = dur - mediaPlayer.getCurrentPosition();

                            msg.obj=millis/1000;
                            handler.sendMessage(msg);
                            try {
                                Thread.sleep(100);
                            }
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();






            }
        });



        callStateListener();


    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String cmd = intent.getStringExtra("command");
            Log.v("tag ", action + " / " + cmd);
            artist = intent.getStringExtra("artist");
            album = intent.getStringExtra("album");
            track = intent.getStringExtra("track");
            Log.v("tag", artist + ":" + album + ":" + track);


        }
    };





    private String[] getAudioList()
    {
        final Cursor mCursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Audio.Media.DISPLAY_NAME,MediaStore.Audio.Media.DATA},null,null
        ,"LOWER("+MediaStore.Audio.Media.TITLE+")ASC");

        int count = mCursor.getCount();
        String[] songs = new String[count];
        String[] mAudioparth = new String[count];

        int i = 0;
        if(mCursor.moveToFirst())
        {
            do{songs[i]=mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
            mAudioparth[i]=mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                i++;
            }while (mCursor.moveToNext());

        }
    mCursor.close();
        return songs;

    }

    private String[] getmAudioPath() {
        final Cursor mCursor = getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                new String[] { MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.DATA }, null, null,
                "LOWER(" + MediaStore.Audio.Media.TITLE + ") ASC");

        int count = mCursor.getCount();

        String[] songs = new String[count];
        String[] path = new String[count];
        int i = 0;
        if (mCursor.moveToFirst())
        {
            do
            {
                songs[i] = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
                path[i] = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                i++;
            } while (mCursor.moveToNext());
        }

        mCursor.close();

        return path;
    }


    private void callStateListener() {
        // Get the telephony manager
        telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        //Starting listening for PhoneState changes
        phoneStateListener = new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                switch (state) {
                    //if at least one call exists or the phone is ringing
                    //pause the MediaPlayer
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                    case TelephonyManager.CALL_STATE_RINGING:
                        if (mediaPlayer != null) {
                            mediaPlayer.pause();
                            ongoingCall = true;
                        }
                        break;
                    case TelephonyManager.CALL_STATE_IDLE:
                        // Phone idle. Start playing.
                        if (mediaPlayer != null) {
                            if (ongoingCall) {
                                ongoingCall = false;
                                mediaPlayer.start();
                            }
                        }
                        break;
                }
            }
        };
        // Register the listener with the telephony manager
        // Listen for changes to the device call state.
        telephonyManager.listen(phoneStateListener,
                PhoneStateListener.LISTEN_CALL_STATE);
    }


}
