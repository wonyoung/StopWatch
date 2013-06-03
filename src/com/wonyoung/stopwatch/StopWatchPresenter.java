package com.wonyoung.stopwatch;

public class StopWatchPresenter {

	private final StopWatchModel model;
	private final StopWatchView view;

	public StopWatchPresenter(StopWatchModel model, StopWatchView view) {
		this.model = model;
		this.view = view;
	}

	public void initialize() {
		view.setTime(model.getLastTime());
		view.setRecord(model.getLastRecord());
	}

	public void start() {
		model.start();
		view.enableStartButton(false);
		view.enableStopButton(true);
		view.enableRecordBUtton(true);
	}

}
