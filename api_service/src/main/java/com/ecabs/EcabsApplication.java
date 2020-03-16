package com.ecabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * Producer application that receives Booking from the Rest client and sends them to Consumer.
 * </p>
 *
 * @author Railean Iurie
 */
@SpringBootApplication
public class EcabsApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcabsApplication.class, args);
    }

}
