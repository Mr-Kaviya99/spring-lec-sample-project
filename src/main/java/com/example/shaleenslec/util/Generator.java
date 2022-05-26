package com.example.shaleenslec.util;

import com.example.shaleenslec.dto.core.GeneratedIdentificationDTO;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Generator {

    private final Random RANDOM = new Random();
    private final String NUMERIC = "0123456789";
    public final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Long generateDigits(int length) {
        return generateRandomDigits(length);
    }

    private Long generateRandomDigits(int length) {
        StringBuilder returnValue = new StringBuilder(length);


        for (int i = 0; i < length; i++) {
            returnValue.append(NUMERIC.charAt(RANDOM.nextInt(NUMERIC.length())));
        }
        return Long.parseLong(returnValue.toString());
    }
    public GeneratedIdentificationDTO createId() {
        StringBuilder sb = new StringBuilder(4);

        //remove spaces & toUppercase
//            int randomNumber = new Random().nextInt(16 - 1) + 1;
        for (int i = 0; i < 4; i++) {
            // generate a random number between
            int index = (int) (ALPHABET.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(ALPHABET.charAt(index));
        }

        Long digits = generateDigits(8);

        System.out.println("digits "+digits+" "+sb.toString());
        return new GeneratedIdentificationDTO(digits, sb.toString());
    }
}
