package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.test.context.TestPropertySource;
import pageObject.CommonPageObject;
import pageObject.MultiCityPageObject;
import pageObject.One_RoundWayTripPageObject;
import testConfiguration.ApplicationDetails;

import java.beans.ConstructorProperties;

@Configuration
//@TestPropertySource(properties = { "spring.config.location = classpath:Application.yaml"})

//@TestPropertySource(properties ={"classpath:/Application.yaml"})
public class UISpring {
    @Bean
    public CommonPageObject commonPageObject(){
        return new CommonPageObject();
    }

    @Bean
    public MultiCityPageObject multiCityPageObject(){
        return new MultiCityPageObject();
    }
    @Bean
    public One_RoundWayTripPageObject one_roundWayTripPageObject(){
        return new One_RoundWayTripPageObject();
    }


}
