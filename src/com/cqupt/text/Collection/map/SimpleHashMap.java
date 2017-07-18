package com.cqupt.text.Collection.map;

import java.util.*;

/**
 * @author weigs
 * @date 2017/7/14 0014
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;

    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets =
            new LinkedList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> iterator = bucket.listIterator();
        while (iterator.hasNext()) {
            MapEntry<K, V> ipair = iterator.next();
            if (ipair.getKey().equals(key)) {
                oldValue = ipair.getValue();
                iterator.set(pair);
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            return null;
        for (MapEntry<K, V> ipair : buckets[index])
            if (ipair.getKey().equals(key))
                return ipair.getValue();
        return null;
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null)
                continue;
            for (MapEntry<K, V> mapEntry : bucket)
                set.add(mapEntry);

        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.put("nihao","haohaohao");
        simpleHashMap.put("anhui","hefei");
        simpleHashMap.put("chongqing","chongqing");
        simpleHashMap.put("shanghai","kepaidedifang");

        System.out.println(simpleHashMap);
    }
}
