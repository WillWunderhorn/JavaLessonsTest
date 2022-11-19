package springstart;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import springstart.models.PrimitiveInfo;

// TODO: 06.11.2022
//вместо h2 использовать postgres
//добавить liquibase + импорт пресета данных из csv
//сделать обвязку на docker-compose

@SpringBootApplication
public class SpringStartApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringStartApplication.class, args);

        PrimitiveInfo objects = new PrimitiveInfo();
        objects.addObject(0l, "First Message");
        objects.addObject(1l, "Second Message");
        objects.addObject(2l, "Third Message");
//        objects.clearTable();
//        objects.findById(0l);
//        objects.findById(1l);
//        objects.findById(2l);
        objects.findAll();

    }
}
