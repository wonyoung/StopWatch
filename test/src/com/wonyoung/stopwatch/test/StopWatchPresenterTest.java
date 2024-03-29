package com.wonyoung.stopwatch.test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.wonyoung.stopwatch.StopWatchModel;
import com.wonyoung.stopwatch.StopWatchModel.CallBack;
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
		
		verify(view).enableStartButton(true);
		verify(view).enableStopButton(false);
		verify(view).enableRecordButton(false);
		verify(view).enableResumeButton(false);
		verify(view).enableResetButton(false);
	}

	@Test
	public void showsStopAndRecordWhenStart() throws Exception {
		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				CallBack listener = (StopWatchModel.CallBack) invocation.getArguments()[0]; 
				listener.update("00:02:03");
				return null;
			}
		}).when(model).start(any(StopWatchModel.CallBack.class));
		
		presenter.start();
		
		verify(model).start(any(StopWatchModel.CallBack.class));
		verify(view).enableStartButton(false);
		verify(view).enableStopButton(true);
		verify(view).enableRecordButton(true);
		verify(view).setTime("00:02:03");
	}
	
	@Test
	public void showsUpdatedTimeWhenUpdate() throws Exception {
		presenter.update("00:02:03");
		
		verify(view).setTime("00:02:03");
	}
	
	@Test
	public void showsConituneAndInitWhenStop() throws Exception {
		presenter.stop();
		
		verify(model).stop();
		verify(view).enableStopButton(false);
		verify(view).enableRecordButton(false);
		verify(view).enableResumeButton(true);
		verify(view).enableResetButton(true);
	}
	
	@Test
	public void showsStartWhenReset() throws Exception {
		presenter.reset();
		
		verify(model).reset();
		verify(view).enableResumeButton(false);
		verify(view).enableResetButton(false);
		verify(view).enableStartButton(true);
	}
	
	@Test
	public void showsStopAndRecordWhenResume() throws Exception {
		presenter.resume();
		
		verify(model).start(any(CallBack.class));
		verify(view).enableResumeButton(false);
		verify(view).enableResetButton(false);
		verify(view).enableStopButton(true);
		verify(view).enableRecordButton(true);
	}

	
	@Test
	public void showsRecordTimeWhenRecord() throws Exception {
		when(model.getTime()).thenReturn("01:02:03");
		
		presenter.record();

		verify(model).getTime();
		verify(view).setRecord("01:02:03");
	}	
}
