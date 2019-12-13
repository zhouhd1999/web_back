package cn.zhd.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

//@MapperScan("cn.zhd.springboot.mapper")//代替mapper

@SpringBootApplication
@EnableAsync
public class SpringbootApplication {




    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
