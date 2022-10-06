class TimeMap {
    public HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(map.get(key) == null){
            TreeMap<Integer, String> treeMap = new TreeMap<>();
            map.put(key, treeMap);
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(map.get(key) == null)
            return "";
        TreeMap<Integer, String> treeMap = map.get(key);
        Integer floorKey = treeMap.floorKey(timestamp);
        if(floorKey == null)
            return "";
        return treeMap.get(floorKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
