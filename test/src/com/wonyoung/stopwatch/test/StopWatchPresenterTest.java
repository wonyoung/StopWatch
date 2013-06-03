package com.wonyoung.stopwatch.test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import com.wonyoung.stopwatch.StopWatchModel;
import com.wonyoung.stopwatch.StopWatchPresenter;
import com.wonyoung.stopwatch.StopWatchView;
import static org.mockito.Mockito.*;

public class StopWatchPresenterTest {

	private StopWatchModel model;
	private StopWatchView view;
	private StopWatchPresenter presenter;

	@Before
	public void setUp() throws Exception {
		model = mock(StopWatchModel.class);
		view = mock(StopWatchView.class);
		presenter = new StopWatchPresenter(model, view);
	}
	
	@Test
	public void showsLastTimeAndRecordWhenInitialize() throws Exception {
		when(model.getLastTime()).thenReturn("00:01:02");
		when(model.getLastRecord()).thenReturn("00:00:34");
		
		presenter.initialize();
		
		verify(model).getLastTime();
		verify(model).getLastRecord();
		verify(view).setTime("00:01:02");
		verify(view).setRecord("00:00:34");
	}

	@Test
	public void showsStopAndRecordWhenStart() throws Exception {
		presenter.start();
		
		verify(model).start();
		verify(view).enableStartButton(false);
		verify(view).enableStopButton(true);
		verify(view).enableRecordButton(true);
	}
	
	@Test
	public void showsUpdatedTimeWhenUpdate() throws Exception {
		presenter.update("00:02:03");
		
		verify(view).setTime("00:02:03");
	}
}
