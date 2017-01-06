package com.taishi.instagrambackground;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

	AnimationDrawable anim;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			findViewById(android.R.id.content).setSystemUiVisibility(
					View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
		}

		setContentView(R.layout.activity_main);

		LinearLayout container = (LinearLayout) findViewById(R.id.container);

		anim = (AnimationDrawable) container.getBackground();
		anim.setEnterFadeDuration(3000);
		anim.setExitFadeDuration(1000);
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (anim != null && !anim.isRunning())
			anim.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (anim != null && anim.isRunning())
			anim.stop();
	}
}
