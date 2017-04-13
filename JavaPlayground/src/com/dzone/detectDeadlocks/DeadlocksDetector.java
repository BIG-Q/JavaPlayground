package com.dzone.detectDeadlocks;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DeadlocksDetector {
	private final DeadlockHandler deadlockHandler;
	private final long period;
	private final TimeUnit timeunit;
	private final ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
	
	private final ScheduledExecutorService ex = Executors.newScheduledThreadPool(1);
	
	final Runnable deadlockCheck = new Runnable() {
		
		@Override
		public void run() {
			long[] deadloackedThreads = DeadlocksDetector.this.mbean.findDeadlockedThreads();
			
			if(deadloackedThreads != null){
				ThreadInfo[] threadInfos = DeadlocksDetector.this.mbean.getThreadInfo(deadloackedThreads);
				
				DeadlocksDetector.this.deadlockHandler.handleDeadlock(threadInfos);
			}
		}
	};
	
	public DeadlocksDetector(final DeadlockHandler deadlockHandler, final long period, final TimeUnit timeUnit){
		this.deadlockHandler = deadlockHandler;
		this.period = period;
		this.timeunit = timeUnit;
	}
	
	public void start(){
		this.ex.scheduleAtFixedRate(this.deadlockCheck, this.period, this.period, this.timeunit);
	}
}
