package com.capgemini.resources.maps;

import com.capgemini.resources.maps.IgnoreCaseMap;

/**
 * Created by MINAAD on 13-12-2017.
 */
public class IgnoreSymbolsMap<K, V> extends IgnoreCaseMap<K, V> {

    private final String specialChars = "[^\\dA-Za-z ]";

    public V get(String key) {
        return super.get(formatKey(key));
    }

    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        return super.put((K) formatKey(key.toString()), value);
    }

    public String formatKey(String key){
        return super.formatKey(key.replaceAll(specialChars, ""));
    }
}