package com.cs_c.memorymat;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import java.lang.ref.WeakReference;


public class MainActivity extends ActionBarActivity {
    private TextView helloTextView;
    private Handler mHandler = new Handler();

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    helloTextView = (TextView) findViewById(R.id.hello_TextView_MainActivity);
    mHandler.postDelayed(new MyRunnable(helloTextView), 100000);
}

    private static final class MyRunnable implements Runnable {
        private final WeakReference<TextView> helloTextViewWeakRef;

        private MyRunnable(TextView helloTextView) {
            helloTextViewWeakRef = new WeakReference<TextView>(helloTextView);
        }

        @Override
        public void run() {
            final TextView textView = helloTextViewWeakRef.get();
            if (textView != null) {
                textView.setText("New Hello World");
            }
        }
    }
}
