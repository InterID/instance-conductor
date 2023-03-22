package ru.interid.instanceconductor.business;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SimplePrefixGenerator implements PrefixGenerator {

    @Override
    public String generateFreePrefix() {
        return generateHex();
    }

    public static String generateHex() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(Integer.toHexString(random.nextInt(16)));
        }
        return sb.toString().toUpperCase();
    }

}
