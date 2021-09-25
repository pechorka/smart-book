package com.pechor.smart.book;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TextDialogActivity extends Activity {
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
        dialog.setContentView(R.layout.webview);

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

        dialog.setOnDismissListener(dialogInterface -> TextDialogActivity.this.finish());

        dialog.show();
    }
}
