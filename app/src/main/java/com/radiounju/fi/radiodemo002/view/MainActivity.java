package com.radiounju.fi.radiodemo002.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.radiounju.fi.radiodemo002.R;
import com.radiounju.fi.radiodemo002.model.Noticia;
import com.radiounju.fi.radiodemo002.service.APIService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textPlayMessage;
    ImageView imageShare;
    ImageView imagePlay;
    AudioManager audioManager;
    Boolean statusButton = true;
    String STREAM_URL ="http://190.114.254.141:8201/";
    //String STREAM_URL ="http://estudio.cnnradioargentina.com.ar:8000/stream";
    MediaPlayer mediaPlayer;
    ViewPager viewPager;
    TabLayout tabLayout;
    List<Noticia> noticiaList;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mediaPlayer = new MediaPlayer();
        noticiaList = new ArrayList<>();
        // Set up the ViewPager with the sections adapter.
        viewPager = (ViewPager) findViewById(R.id.container);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Creado para la radio Unju
        imageShare = (ImageView)findViewById(R.id.imageShare);
        imagePlay = (ImageView)findViewById(R.id.imagePlay);
        textPlayMessage = (TextView)findViewById(R.id.textPlayRadio);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        imagePlay.setImageResource(R.drawable.ic_play_arrow_black_24dp);

        this.playRadio(imagePlay);
        obtenerNoticiasDelServidor();
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    //Metodos Creados para Radio Unju


    //Metodo para compartir link de descarga
    public void shared(View v){
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        String shareBody = "www.youtube.com";
        myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
        startActivity(Intent.createChooser(myIntent,"Radio Unju - Play Store"));
    }

    public void sharedLink(View v){
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        String shareBody = "http://unjuradio.com/category/ultimas-noticias/";
        myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
        startActivity(Intent.createChooser(myIntent,"Radio Unju - Play Store"));
    }

    public void upSound(View v){
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
    }

    public void downSound(View v){
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
    }

    public void playRadio(View v){
        if(statusButton == true){
            statusButton = false;
            imagePlay.setImageResource(R.drawable.ic_pause_black_24dp);
            textPlayMessage.setText("Estas escuchando: Radio Universidad");
            Toast.makeText(getApplicationContext(),"Radio Encendida",Toast.LENGTH_LONG).show();
            try{
                mediaPlayer.reset();
                mediaPlayer.setDataSource(STREAM_URL);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.
                        OnPreparedListener(){
                    @Override
                    public void onPrepared(MediaPlayer mp){
                        mp.start();
                    }
                });
            } catch (IOException e){
                e.printStackTrace();
            }
        }else{
            statusButton = true;
            imagePlay.setImageResource(R.drawable.ic_play_arrow_black_24dp);
            textPlayMessage.setText("");
            Toast.makeText(getApplicationContext(), "Radio Apagada", Toast.LENGTH_LONG).show();
            mediaPlayer.stop();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.imageShare) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void obtenerNoticiasDelServidor() {
        /***********************************************************************************************/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);
        Call<List<Noticia>> call = apiService.getNoticias();

        call.enqueue(new Callback<List<Noticia>>() {
            @Override
            public void onResponse(Call<List<Noticia>> call, Response<List<Noticia>> response) {
                noticiaList = new ArrayList<>();
                noticiaList = response.body();
                viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), noticiaList);
                //viewPager.setAdapter(viewPagerAdapter);
            }

            @Override
            public void onFailure(Call<List<Noticia>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        /********************************************************************************************/
    }

    public void refreshNow (){
        finish();
        overridePendingTransition( 0, 0);
        startActivity(getIntent());
        overridePendingTransition( 0, 0);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        /*if (newConfig.orientation == android.content.res.orientation.Landscape) {
            button.Visibility = ViewStates.Invisible;        //invisible in landscape.
        } else if (newConfig.Orientation == Android.Content.Res.Orientation.Portrait) {
            button.Visibility = ViewStates.Visible;         //viible in portrait.
        }*/
    }
}
