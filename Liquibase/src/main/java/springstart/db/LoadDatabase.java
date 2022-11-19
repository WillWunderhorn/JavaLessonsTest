package springstart.db;

import springstart.models.PrimitiveInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springstart.repo.PrimitiveInfoRepo;
/*
@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDb(PrimitiveInfoRepo repo){
        return args -> {
            log.info("Preload " + repo.save(new PrimitiveInfo().setMessage("Hello World")));
            log.info("Preload " + repo.save(new PrimitiveInfo().setMessage("Postgres worked!")));
        };
    }
}
*/