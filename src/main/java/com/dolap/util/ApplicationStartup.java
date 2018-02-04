package com.dolap.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.dolap.entity.User;
import com.dolap.service.IUserService;
import com.dolap.service.impl.UserService;

@Component
public class ApplicationStartup 
implements ApplicationListener<ApplicationReadyEvent> {
       @Autowired
       IUserService userService;
  /**
   * This event is executed as late as conceivably possible to indicate that 
   * the application is ready to service requests.
   */
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		if (userService.findByEmail("admin@dolap.com") == null) {
			User user = new User();
			user.setEmail("admin@dolap.com");
			user.setName("dolap");
			user.setPassword("dolap");
			user.setRole(Role.ADMIN.name());
			userService.insert(user);
		}

	}
}