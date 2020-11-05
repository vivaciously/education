package net.codingartist.algo_ds.threads;

public class UncaughtExceptionHandlerDriver {

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			throw new RuntimeException("Intentionally thrown for the test");
		});
		t.setUncaughtExceptionHandler(new UncaughtExceptionHandler());
		t.start();
	}
}
