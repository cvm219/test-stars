package cvm.stars;

import cvm.stars.dao.DiscovererDAO;
import cvm.stars.dao.StarDAO;
import cvm.stars.dao.StarTypeDAO;
import cvm.stars.entities.Discoverer;
import cvm.stars.entities.Star;
import cvm.stars.entities.StarType;
import cvm.stars.mybatis.MyBatisConnectionFactory;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * Created by cvm on 15.05.2017.
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
