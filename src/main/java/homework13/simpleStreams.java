package homework13;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class simpleStreams {
    public static double calculateAverageCol() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        OptionalDouble average = list.stream().mapToDouble(Integer::intValue).average();
        return average.getAsDouble();
    }
    public static List<String> collection1(){
        return Arrays.asList("MiHail", "vlAd", "Oleg", "Ivan", "alex", "evGen");
    }
    public static List<String> upperCaseAndSort(Collection<String> collection){
        Predicate<String> vowelLetter = Pattern
                .compile("^(?i:[aeiou]).*")
                .asPredicate();
        return collection
                .stream()
                .filter(vowelLetter)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
    public static List<String> collection2(){
        return Arrays.asList("MIHAIL", "vlad", "OLEG", "ivan", "alex", "EVGEN");
    }

    public static List<String> loverCaseAndSort(Collection<String> collection){
        Predicate<String> lowerCase = Pattern
                .compile("^([a-z]).*")
                .asPredicate();

        return collection
                .stream()
                .filter(lowerCase)
                .filter(e -> (e.length() == 4))
                .collect(Collectors.toList());
    }
}