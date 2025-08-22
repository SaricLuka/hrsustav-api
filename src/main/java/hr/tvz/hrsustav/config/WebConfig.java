package hr.tvz.hrsustav.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import hr.tvz.hrsustav.interceptor.TimingInterceptor;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class WebConfig implements WebMvcConfigurer {

	private final TimingInterceptor timingInterceptor;

	@Override
	public void addInterceptors(@NonNull InterceptorRegistry registry) {
		registry.addInterceptor(timingInterceptor).addPathPatterns("/**");
	}
}