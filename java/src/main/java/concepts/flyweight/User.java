package concepts.flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// Inefficient way if the users are in millions
public class User {
    private String fullName;

    public User(String fullName) {
        this.fullName = fullName;
    }
}


class NewUser{

    static List<String> strings = new ArrayList<>();
    private int [] names;

    public NewUser(String fullName) {
        Function<String,Integer>  getOrAdd = (String s) -> {
            int index = strings.indexOf(s);
            if(index!=-1) return index;
            else{
                strings.add(s);
                return strings.size() -1;
            }
        };
        names = Arrays.stream(fullName.split(" ")).mapToInt(getOrAdd::apply).toArray();


    }
}