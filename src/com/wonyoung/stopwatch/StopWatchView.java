package com.wonyoung.stopwatch;

public interface StopWatchView {

	void setTime(String time);

	void setRecord(String record);

	void enableStartButton(boolean enabled);

	void enableStopButton(boolean enabled);

	void enableRecordButton(boolean enabled);

}
