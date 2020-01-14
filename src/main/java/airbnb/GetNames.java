package airbnb;

import java.io.File;
import java.util.Arrays;

public class GetNames {

    public static void main(String[] args) {
        File file = new File("/Users/chenlijie/Downloads/sell");

        File[] f = file.listFiles();
        Arrays.sort(f, (f1, f2) -> {return (int)(f1.lastModified() - f2.lastModified());});

        for (int i = 1; i <= f.length; i++) {
            System.out.println(i + ". " + f[i - 1].getName().replaceFirst("\\.jpg", "") + " : $");
        }

//        String[] str = file.list();
//        for (int i = 1; i <= str.length; i++) {
//            System.out.println(i + ". " + str[i - 1].replaceFirst("\\.jpg", "") + " : $");
//        }
    }
}
