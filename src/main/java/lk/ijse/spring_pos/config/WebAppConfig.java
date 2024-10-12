package lk.ijse.spring_pos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.spring_pos")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "lk.ijse.spring_pos")
@EnableTransactionManagement
public class WebAppConfig {}
