**1. how to read key/value elements of a map in java:**
```
for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
    int value = entry.getValue();
    int key = entruy.getKey();
}
```

**2. how to count frequency of elemnt using a map in java:**
```
for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
```