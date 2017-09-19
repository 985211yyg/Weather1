package com.example.yungui.weather.tts;


import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;


/**
 * Created by yungui on 2017/9/6.
 */

public class IflyTTS {
//
//    private static IflyTTS iflyTTS;
//    private TextToSpeech textToSpeech;
//
//    public static IflyTTS getInatance(Context context) {
//        if (iflyTTS == null) {
//            synchronized (IflyTTS.class) {
//                iflyTTS = new IflyTTS(context);
//            }
//        }
//        return iflyTTS;
//    }
//
//    private IflyTTS(TextToSpeech textToSpeech) {
//        this.textToSpeech = textToSpeech;
//    }
    //
//    public IflyTTS(Context context) {
//        //1.创建SpeechSynthesizer对象
//        mTts = SpeechSynthesizer.createSynthesizer(context, null);
//        //2.合成参数设置
//        //设置引擎类型为本地
//        mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_LOCAL);
//        //设置本地发音人
//        mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
//        //加载本地合成资源，resPath为本地合成资源路径
//        //mTts.setParameter(ResourceUtil.TTS_RES_PATH, resPath);
//        //设置合成音频保存位置（可自定义保存位置），保存在“./sdcard/iflytek.pcm”
//        //保存在SD卡需要在AndroidManifest.xml添加写SD卡权限
//        //如果不需要保存合成音频，注释该行代码
//        //mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./sdcard/iflytek.pcm");
//        //3.开始合成
//
//    }
//    public void speak() {
//        mTts.startSpeaking("科大讯飞，让世界聆听我们的声音", new SynthesizerListener() {
//            @Override
//            public void onSpeakBegin() {
//
//            }
//
//            @Override
//            public void onBufferProgress(int i, int i1, int i2, String s) {
//
//            }
//
//            @Override
//            public void onSpeakPaused() {
////                mTts.pauseSpeaking();
//
//            }
//
//            @Override
//            public void onSpeakResumed() {
////                mTts.resumeSpeaking();
//
//            }
//
//            @Override
//            public void onSpeakProgress(int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onCompleted(SpeechError speechError) {
////                mTts.destroy();
//
//            }
//
//            @Override
//            public void onEvent(int i, int i1, int i2, Bundle bundle) {
//
//            }
//        });
//
//
//    }
}
