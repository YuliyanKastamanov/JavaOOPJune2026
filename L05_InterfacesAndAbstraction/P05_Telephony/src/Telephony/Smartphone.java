package Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable{

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();
        this.urls.stream().forEach( url -> {
            if(isValidUrl(url)){
                builder.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            }else {
                builder.append("Invalid URL!").append(System.lineSeparator());
            }
        });
        return builder.toString();
    }

    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();
        this.numbers.stream().forEach(number -> {
            if(isValidNumber(number)){
                builder.append(String.format("Calling... %s%n", number)).append(System.lineSeparator());
            }else {
                builder.append(String.format("Invalid number!%n"));
            }
        });
        return builder.toString();
    }

    private boolean isValidNumber(String number) {

        for (int index = 0; index < number.length(); index++) {
            if(!Character.isDigit(number.charAt(index))){
                return false;
            }

        }
        return true;
    }


    private boolean isValidUrl(String url) {

        for (int index = 0; index < url.length(); index++) {

            if(Character.isDigit(url.charAt(index))){
                return false;
            }
        }

        return true;

    }
}
