package com.wonyoung.stopwatch.test;

import static org.junit.Assert.*;


import org.junit.Test;

import com.wonyoung.stopwatch.StopWatchModel;
import com.wonyoung.stopwatch.StopWatchPresenter;
import com.wonyoung.stopwatch.StopWatchView;
import static org.mockito.Mockito.*;

public class StopWatchPresenterTest {

	@Test
	public void showsLastTimeAndRecordWhenInitialize() {
		StopWatchModel model = mock(StopWatchModel.class);
		StopWatchView view = mock(StopWatchView.class);
		StopWatchPresenter presenter = new StopWatchPresenter(model, view);

		when(model.getLastTime()).thenReturn("00:01:02");
		when(model.getLastRecord()).thenReturn("00:00:34");
		
		presenter.initialize();
		
		verify(model).getLastTime();
		verify(model).getLastRecord();
		verify(view).setTime("00:01:02");
		verify(view).setRecord("00:00:34");
	}

}
