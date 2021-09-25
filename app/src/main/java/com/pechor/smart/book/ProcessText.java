package com.pechor.smart.book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ProcessText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CharSequence text = getIntent()
                .getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);

        Intent intent = new Intent(this, TextDialogActivity.class);
// NEW_TASK allows the new dialog activity to be separate from the existing activity.
// REORDER_TO_FRONT causes the dialog activity to be moved to the front,
// if it's already running.
// Without the NEW_TASK flag, the existing "base" activity
// would be moved to the front as well.
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(TextDialogActivity.TEXT_TO_PROCESS_PARAM, text.toString());
// The activity must be started from the application context.
// I'm not sure why exactly.
        this.getApplicationContext().startActivity(intent);

        finish();
    }

}