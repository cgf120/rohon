package cn.rohon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author cgf_p
 */
@SpringBootApplication
@EnableOpenApi
public class RohonStarter {
    public static void main(String[] args) {
        SpringApplication.run(RohonStarter.class,args);
    }
}
