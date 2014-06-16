package com.android.telecomm.testapps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telecomm.TelecommConstants;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.android.telecomm.tests.R;

public class TestDialerActivity extends Activity {
    private EditText mNumberView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testdialer_main);
        findViewById(R.id.set_default_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setDefault();
            }
        });
        findViewById(R.id.place_call_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                placeCall();
            }
        });

        mNumberView = (EditText) findViewById(R.id.number);
        updateEditTextWithNumber();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        updateEditTextWithNumber();
    }

    private void updateEditTextWithNumber() {
        Intent intent = getIntent();
        if (intent != null) {
            mNumberView.setText(intent.getDataString());
        }
    }

    private void setDefault() {
        final Intent intent = new Intent(TelecommConstants.ACTION_CHANGE_DEFAULT_PHONE);
        intent.putExtra(TelecommConstants.EXTRA_PACKAGE_NAME, this.getBasePackageName());
        startActivity(intent);
    }

    private void placeCall() {
        // TODO: Place a call with the number entered in the number field
    }
}
