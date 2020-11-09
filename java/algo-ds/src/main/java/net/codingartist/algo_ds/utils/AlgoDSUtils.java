package net.codingartist.algo_ds.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

public class AlgoDSUtils {

	private AlgoDSUtils() {
		throw new AssertionError("non instantiability");
	}
	
	public static String takeThreadDump() {
		final StringBuilder sb = new StringBuilder();
		final ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
		final ThreadInfo[] threadInfos = threadMxBean.getThreadInfo(threadMxBean.getAllThreadIds(), 100);
		Arrays.stream(threadInfos).forEach((t) -> {
			sb.append('"');
			sb.append(t.getThreadName());
			sb.append("\"");
			final Thread.State state = t.getThreadState();
			sb.append("\n  java.lang.Thread.State: ");
			sb.append(state);
			final StackTraceElement[] stackTraceElements = t.getStackTrace();
			Arrays.stream(stackTraceElements).forEach((st) -> {
				sb.append("\n           at ");
				sb.append(st);
			});
		});
		return sb.toString();
	}
	
	public static Object deepCopy(Object original) {
		   ByteArrayOutputStream outputStream = null;
		   ObjectOutputStream objOutputStream = null;
		   ByteArrayInputStream inputStream = null;
		   ObjectInputStream objInputStream = null;
		   try {
			     outputStream = new ByteArrayOutputStream();
			     objOutputStream = new ObjectOutputStream(outputStream);
			     objOutputStream.writeObject(original);
			     inputStream = new ByteArrayInputStream(outputStream.toByteArray());
			     objInputStream = new ObjectInputStream(inputStream);
			     return objInputStream.readObject();
		   } catch (Exception e) {
			     e.printStackTrace();
			     return null;
		   } finally {
			   try {
				   if(objInputStream != null) {
					   objInputStream.close();
				   }
				   if(inputStream != null) {
					   inputStream.close();
				   }
				   if(objOutputStream != null) {
					   objOutputStream.close();
				   }
				   if(outputStream != null) {
					   outputStream.close();
				   }
			   } catch(Exception e) {
				   e.printStackTrace();
			   }
		   }
	}
}
