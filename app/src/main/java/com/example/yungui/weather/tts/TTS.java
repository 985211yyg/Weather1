package com.example.yungui.weather.tts;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by yungui on 2017/9/7.
 */

public class TTS implements TextToSpeech.OnInitListener {
    private Context context;
    private TextToSpeech textToSpeech;
    private static TTS tts;

    public static TTS getInstance(Context context) {
        if (tts == null) {
            synchronized (TTS.class) {
                tts = new TTS(context);
            }
        }
        return tts;

    }
    private TTS(Context context) {
        this.context = context;
        textToSpeech = new TextToSpeech(context, this);
        //设置中文
        textToSpeech.setLanguage(Locale.CHINESE);
        //设置音调
        textToSpeech.setPitch(1.0f);
        //设置语速
        textToSpeech.setSpeechRate(0.8f);
    }

    public void speak(String s) {
        String text = s;
        if (TextUtils.isEmpty(s)) {
            text = "你是谁呀，我是谁";
        }
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null,null);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            if (status == TextToSpeech.SUCCESS) {
                int result = textToSpeech.setLanguage(Locale.CHINESE);
                if (result == TextToSpeech.LANG_MISSING_DATA
                        || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(context, "数据丢失或不支持", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
    public void stop() {
        textToSpeech.stop();
        textToSpeech.shutdown();
    }
}
