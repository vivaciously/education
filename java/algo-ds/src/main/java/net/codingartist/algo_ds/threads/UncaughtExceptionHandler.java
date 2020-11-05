package net.codingartist.algo_ds.threads;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
	
	private static final Logger logger = LogManager.getLogger(UncaughtExceptionHandler.class);

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("UncaughtException: ").append(e).append("\n");
		final StackTraceElement[] stackTrace = e.getStackTrace();
		Arrays.stream(stackTrace).forEach((st) -> {
			sb.append("\n      at ");
			sb.append(st);
		});
		sb.append("\n\n");
		sb.append("ThreadId: ").append(t.getId()).append("\n");
		sb.append("ThreadName: ").append(t.getName()).append("\n");
		final Thread.State state = t.getState();
		sb.append("java.lang.Thread.State: ");
		sb.append(state);
		sb.append("\n");
		final StackTraceElement[] stackTraceElements = t.getStackTrace();
		Arrays.stream(stackTraceElements).forEach((st) -> {
			sb.append("\n      at ");
			sb.append(st);
		});
		logger.warn(sb.toString());
	}

}
