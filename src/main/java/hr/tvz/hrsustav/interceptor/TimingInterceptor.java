package hr.tvz.hrsustav.interceptor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class TimingInterceptor implements HandlerInterceptor {

	private static final String START_TIME_ATTR = "startTime";

	private Environment environment;

	@Override
	public boolean preHandle(
			@NonNull HttpServletRequest request,
			@NonNull HttpServletResponse response,
			@NonNull Object handler) {
		request.setAttribute(START_TIME_ATTR, System.nanoTime());

		return true;
	}

	@Override
	public void afterCompletion(
			@NonNull HttpServletRequest request,
			@NonNull HttpServletResponse response,
			@NonNull Object handler,
			@Nullable Exception ex) {

		var startTime = (Long) request.getAttribute(START_TIME_ATTR);
		if (startTime != null) {
			Long duration = System.nanoTime() - startTime;
			val activeProfiles = Arrays.toString(environment.getActiveProfiles());

			if (request.getRequestURI().contains("api-docs") || request.getRequestURI().contains("swagger-ui")) return;

			val logLine = String.format("%n%s,%s,%s,%d",
					activeProfiles,
					request.getRequestURI(),
					request.getMethod(),
					duration);

			try (var writer = new FileWriter("logs/timing.csv", true)) {
				writer.write(logLine);
			} catch (IOException e) {
				log.error("Neuspiješno zapisivanje vremena.", e);
			}
		}
	}
}