package com.pechor.smart.book;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class DialogActivity extends Activity {
    public static final String TEXT_TO_PROCESS_PARAM = "TEXT_TO_PROCESS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        String text = getIntent().getStringExtra(TEXT_TO_PROCESS_PARAM);

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_process_text);

        WebView wv =  dialog.findViewById(R.id.webview);

        wv.loadUrl("https:\\www.google.com/search?q="+text.replace(' ','+'));
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }
        });

        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);

        dialog.setOnDismissListener(dialogInterface -> DialogActivity.this.finish());

        dialog.show();
    }
}
