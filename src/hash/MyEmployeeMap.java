package hash;

import java.util.HashMap;

public class MyEmployeeMap extends HashMap<Object, Object> {

    @Override
    public Object put(Object key, Object value) {

        if(this.containsKey(key))
            throw new IllegalArgumentException("Duplicate key entered");

        return super.put(key, value);
    }
}
