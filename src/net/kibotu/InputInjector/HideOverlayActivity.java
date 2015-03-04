package net.kibotu.InputInjector;

import android.app.Activity;

import android.os.Bundle;

public class HideOverlayActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		OverlayServiceImpl.stop();
		finish();
	}
}
