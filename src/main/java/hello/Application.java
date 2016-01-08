

package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(Application.class, args);

        // final String springConfigName = "spring/batch-context.xml";
        // final ApplicationContext context = new
        // ClassPathXmlApplicationContext(springConfigName);
        //
        // new SpringApplicationBuilder()
        // .bannerMode(Banner.Mode.OFF)
        // .child(Application.class)
        // .contextClass(context)
        // .run(args);

    }
}
