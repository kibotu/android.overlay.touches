package net.kibotu.InputInjector;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.Log;
import android.view.*;
import android.widget.*;

public class InputListenerService extends Service{

    private RelativeLayout layout;
    private String TAG = "Felix";
    private LinearLayout overlay;

    @Override
    public void onCreate() {
        Log.v("Felix", "Service created.");
        super.onCreate();
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT);
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        overlay = new LinearLayout(this){

            @Override
            public boolean onInterceptTouchEvent(MotionEvent event) {
                Log.e(TAG, "intercepted touch  event: " + event.getX() + ", " + event.getY());
                return super.onInterceptTouchEvent(event); // With this i tell my layout to consume all the touch events from its childs
            }

            @Override
            public boolean onTouchEvent(MotionEvent event) {
                Log.e(TAG, "onTouchEvent: " + event.getX() + ", " + event.getY() + " " + event.getAction());
                return super.onTouchEvent(event);
            }

//            @Override
//            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//                super.onLayout(changed,left,top,right,bottom);
//                Button b = new Button(getContext());
//
//                LinearLayout.LayoutParams l = new LinearLayout.LayoutParams(
//                        WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
//                        WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//                        PixelFormat.TRANSLUCENT
//                );
//
//                b.setBackground(null);
//                b.setOnTouchListener(new OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View v, MotionEvent event) {
//                        Log.e(TAG, "touch event: " + event.getX() + ", " + event.getY());
//                        return false;
//                    }
//                });
//
//                //addView(b, l);
//            }
        };

        wm.addView(overlay, params);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
