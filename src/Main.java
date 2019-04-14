import immutable_objects.ImmutableList;

import java.util.List;

public class Main {

    private static final List<String> URL_LIST = ImmutableList.of("www.google.com", "www.google.org", "www.gmail.com");

    public static void main(String[] args) {

        System.out.println(URL_LIST);


    }
}
