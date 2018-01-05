package com.capgemini.resources.maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by MINAAD on 13-12-2017.
 */
public class IgnoreCaseMap<K, V> extends LinkedHashMap<K, V> {

    private final String specialChars = "[\\s+]";

    public V get(String key) {
        return super.get(formatKey(key));
    }

    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        return super.put((K) formatKey(key.toString()), value);
    }

    public String formatKey(String key){
        return key.toUpperCase().replaceAll(specialChars, "");
    }

    public V getPartial(String partialKey){
        for (K key:super.keySet()){
            if (key.toString().contains(formatKey(partialKey)))
                return super.get(key);
        }
        return null;
    }

    public V getNum(int itemNumber){
        if (itemNumber <= super.size()){
            itemNumber--;
            Set<Map.Entry<K, V>> mapSet = super.entrySet();
            return super.get(((Map.Entry<K, V>) mapSet.toArray()[itemNumber]).getKey());
        }
        else {
            return null;
        }
    }

}