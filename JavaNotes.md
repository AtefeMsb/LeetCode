**1. how to read elements of a map in java:**
```Map.Entry<Integer, Integer> entry : map.entrySet()```

**2. how to count frequency of elemnt using a map in java:**
```
for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
```