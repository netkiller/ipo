//package cn.netkiller.ipo.config;
//
//import java.util.concurrent.Executor;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.AsyncConfigurer;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//@Configuration
//@EnableAsync
//public class AsyncConfig implements AsyncConfigurer {
//
//	public AsyncConfig() {
//	}
//
//	@Override
//	public Executor getAsyncExecutor() {
//		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//		executor.setCorePoolSize(5);
//		executor.setMaxPoolSize(15);
//		executor.setQueueCapacity(25);
//		executor.initialize();
//		return executor;
//	}
//}
