package net.scheduler.springboot.springbootcrudrestfulwebservices.synchronisation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.antkorwin.xsync.XSync;

@Configuration
public class XSyncConfig {
	@Bean
    public XSync<String> xSync(){
        return new XSync<>();
    }
}
