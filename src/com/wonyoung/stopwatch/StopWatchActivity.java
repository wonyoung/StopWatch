package com.wonyoung.stopwatch;

import android.os.Bundle;
import android.app.Activity;
import android.app.Presentation;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class StopWatchActivity extends Activity implements StopWatchView {

	private StopWatchPresenter presenter;
	private TextView timeTextView;
	private TextView recordTextView;
	private Button startButton;
	private Button stopButton;
	private Button recordButton;
	private Button resumeButton;
	private Button resetButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stop_watch);
		
		timeTextView = (TextView) findViewById(R.id.time_textview);
		recordTextView = (TextView) findViewById(R.id.record_textview);
		startButton = (Button) findViewById(R.id.start_button);
		stopButton = (Button) findViewById(R.id.stop_button);
		recordButton = (Button) findViewById(R.id.record_button);
		resumeButton = (Button) findViewById(R.id.resume_button);
		resetButton = (Button) findViewById(R.id.reset_button);
		
		startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				presenter.start();
			}
		});
		stopButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				presenter.stop();
			}
		});
		resetButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				presenter.reset();
			}
		});
		resumeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				presenter.resume();
			}
		});
		
		StopWatchModel model = new StopWatchModel() {
			@Override
			public void start(CallBack listener) {
				// TODO Auto-generated method stub
			}
			@Override
			public String getLastTime() {
				return "lastTime";
			}
			@Override
			public String getLastRecord() {
				return "lastRecord";
			}
			@Override
			public void stop() {
				// TODO Auto-generated method stub
			}
			@Override
			public void reset() {
				// TODO Auto-generated method stub
			}
			@Override
			public String getTime() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		presenter = new StopWatchPresenter(model , this);
		presenter.initialize();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stop_watch, menu);
		return true;
	}

	@Override
	public void setTime(String time) {
		timeTextView.setText(time);
	}

	@Override
	public void setRecord(String record) {
		recordTextView.setText(record);
	}

	@Override
	public void enableStartButton(boolean enabled) {
		startButton.setEnabled(enabled);
	}

	@Override
	public void enableStopButton(boolean enabled) {
		stopButton.setEnabled(enabled);
	}

	@Override
	public void enableRecordButton(boolean enabled) {
		recordButton.setEnabled(enabled);
	}

	@Override
	public void enableResumeButton(boolean enabled) {
		resumeButton.setEnabled(enabled);
	}

	@Override
	public void enableResetButton(boolean enabled) {
		resetButton.setEnabled(enabled);
	}

}
