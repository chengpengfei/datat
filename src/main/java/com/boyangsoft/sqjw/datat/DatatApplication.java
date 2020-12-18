package com.boyangsoft.sqjw.datat;

import com.boyangsoft.sqjw.datat.service.BzdzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatatApplication implements CommandLineRunner {

    public void run(String... args) throws Exception {
        System.out.println("程序实际上的入口在这里。"+this.bzdzService.transfer());
    }

    public static void main(String[] args) {
        SpringApplication.run(DatatApplication.class, args);
    }


    @Autowired
    public DatatApplication(BzdzService bzdzService) {
        this.bzdzService = bzdzService;
    }

    private final BzdzService bzdzService;

}
