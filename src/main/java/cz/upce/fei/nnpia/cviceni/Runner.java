package cz.upce.fei.nnpia.cviceni;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Runner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner; arguments: ");
        Arrays.stream(args.getSourceArgs())
                .forEach(System.out::println);
    }
}
