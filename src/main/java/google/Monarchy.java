package google;

import java.util.List;

/**
 * Created by chenlijie on 11/14/17.
 */
public interface Monarchy {

    void birth(String child, String parent);
    void death(String name);
    List<String> getOrderOfSuccession();
}
