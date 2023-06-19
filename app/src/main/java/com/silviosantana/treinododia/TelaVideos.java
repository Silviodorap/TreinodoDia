package com.silviosantana.treinododia;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.EditText;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;


public class TelaVideos extends AppCompatActivity {


    WebView meuWebView;
    TextView meuTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_videos);

        meuWebView = (WebView) findViewById(R.id.meuWebView);
        meuTitulo = (TextView) findViewById(R.id.textNomeExercicio);

        meuWebView.setWebViewClient(new MyBrowser());

        meuWebView.getSettings().setJavaScriptEnabled(true);
//        meuWebView.getSettings().setPluginState(PluginState.ON);
        meuWebView.loadUrl("http://www.youtube.com/embed/" + "NkYv6kqL-3k" + "?autoplay=1&vq=small");
        meuWebView.setWebChromeClient(new WebChromeClient());

        String nomeVideo = getIntent().getExtras().getString("nomeVideo");
        meuTitulo.setText(nomeVideo);
    }
    private class MyBrowser extends WebViewClient{
        public  boolean overrideUrlLoading (WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}
