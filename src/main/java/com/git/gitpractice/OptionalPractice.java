package com.git.gitpractice;

import java.util.Optional;

public class OptionalPractice {
    public static void main(String[] args) {
        String sentence  = "I am optional String " ;
        Optional<String> optionalSentence = Optional.ofNullable(sentence);
        String defaultString = "is empty";
        System.out.println(optionalSentence.orElse(defaultString));
    }
}
