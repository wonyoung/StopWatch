package com.wonyoung.stopwatch;

import com.wonyoung.stopwatch.StopWatchModel.CallBack;

public class StopWatchPresenter implements CallBack {

	private final StopWatchModel model;
	private final StopWatchView view;

	public StopWatchPresenter(StopWatchModel model, StopWatchView view) {
		this.model = model;
		this.view = view;
	}

	public void initialize() {
		view.setTime(model.getLastTime());
		view.setRecord(model.getLastRecord());
		
		view.enableStartButton(true);
		view.enableStopButton(false);
		view.enableRecordButton(false);
		view.enableResumeButton(false);
		view.enableResetButton(false);
	}

	public void start() {
		model.start(this);
		view.enableStartButton(false);
		view.enableStopButton(true);
		view.enableRecordButton(true);
	}

	@Override
	public void update(String time) {
		view.setTime(time);
	}

	public void stop() {
		model.stop();
		view.enableStopButton(false);
		view.enableRecordButton(false);
		view.enableResumeButton(true);
		view.enableResetButton(true);
	}

	public void reset() {
		model.reset();
		view.enableResumeButton(false);
		view.enableResetButton(false);
		view.enableStartButton(true);
	}

	public void resume() {
		// TODO Auto-generated method stub
		
	}

}
