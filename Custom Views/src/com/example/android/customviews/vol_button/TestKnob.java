package com.example.android.customviews.vol_button;

import android.app.Activity;
import android.os.Bundle;

import com.example.android.customviews.R;

import dtd.phs.lib.utils.Helpers;

public class TestKnob extends Activity {
	private KnobController knobController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_knob);
		knobController = (KnobController) findViewById(R.id.knob_contr);
	}
}