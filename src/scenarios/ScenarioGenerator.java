package scenarios;

import com.google.common.collect.Sets;
import java.util.*;
import java.util.HashSet;
import static java.util.stream.Collectors.toList;


/**
 * Created by nicoa on 5/15/2017.
 */
public class ScenarioGenerator {

    public static List<Set<String>> GetListsFromInput(String TestedFeature, String Condition1, String Condition2){

        String arrTestedFeature[] = TestedFeature.split("\\r?\\n");
        String arrCondition1[]    = Condition1.split("\\r?\\n");
        String arrCondition2[]    = Condition2.split("\\r?\\n");

        List<Set<String>> sets = new ArrayList<>(
                Arrays.asList(
                        new HashSet<>(Arrays.asList(arrTestedFeature)),
                        new HashSet<>(Arrays.asList(arrCondition1)),
                        new HashSet<>(Arrays.asList(arrCondition2))
                )
        );

        return sets;

    }

    public static String combineLists(List<Set<String>> setsToCombine) {

        Set<List<String>> cartesianProducts = Sets.cartesianProduct(setsToCombine);
        List<List<String>> noDuplicatesInProducts = cartesianProducts
                                                    .stream()//iterate over each cartesian product
                                                    .map(product ->  product.stream()
                                                    .distinct()//remove duplicate values
                                                    .collect(toList())//store updated product as list
                                                    ).collect(toList());//store all products as list

        String text = noDuplicatesInProducts.toString()
                                            .replace("^,", "")
                                             .replace("[", "")
                                              .replace("]", "\n")
                                                .replace("^,", "");
        return text;

    }

}
