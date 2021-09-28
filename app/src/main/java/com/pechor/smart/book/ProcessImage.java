package com.pechor.smart.book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ProcessImage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CharSequence text = getIntent()
                .getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);

        Intent intent = new Intent(this, WebviewActivity.class);
// NEW_TASK allows the new dialog activity to be separate from the existing activity.
// REORDER_TO_FRONT causes the dialog activity to be moved to the front,
// if it's already running.
// Without the NEW_TASK flag, the existing "base" activity
// would be moved to the front as well.
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(WebviewActivity.URL_PARAM, "https://www.google.com/search?tbm=isch&q="+text.toString().replace(' ','+'));
// The activity must be started from the application context.
// I'm not sure why exactly.
        this.getApplicationContext().startActivity(intent);

        finish();
    }
}
