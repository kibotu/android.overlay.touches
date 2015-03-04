package net.kibotu.InputInjector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ShowOverlayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("Felix", "also see http://stackoverflow.com/a/22351854/957370 on how to send touch events using adb");
//        startService(new Intent(this, OverlayServiceImpl.class));
        startService(new Intent(this, InputListenerService.class));
        finish();
    }
}
