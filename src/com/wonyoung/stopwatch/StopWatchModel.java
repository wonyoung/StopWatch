package com.wonyoung.stopwatch;

public interface StopWatchModel {

	public interface CallBack {

		void update(String time);

	}

	String getLastTime();

	String getLastRecord();

	void start(CallBack listener);

	void stop();

	void reset();

	String getTime();
}
