package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    TdlRepository tdlRepository;

    @Override
    public void run(String... strings) throws Exception {
        Tdl tdl = new Tdl();
        tdl.setName("take out trash");
        String date = "2020-05-25";
        LocalDate localDate = LocalDate.parse(date);
        tdl.setDate(localDate);
        tdl.setPriority("high");
        tdlRepository.save(tdl);

        tdl = new Tdl("buy groceries", localDate, "low");
        tdlRepository.save(tdl);
    }
}
