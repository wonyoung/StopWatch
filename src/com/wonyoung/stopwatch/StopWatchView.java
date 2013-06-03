package com.wonyoung.stopwatch;

public interface StopWatchView {

	void setTime(String time);

	void setRecord(String record);

	void enableStartButton(boolean enable);

	void enableStopButton(boolean enable);

	void enableRecordBUtton(boolean enable);

}
