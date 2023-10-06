import java.util.HashMap;

class Main380 {
    public static void main(String[] args) {
        // 380. 时钟插入、删除和获取随机元素
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs);
        System.out.println(rs.insert(1));
        System.out.println(rs.remove(2));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
        System.out.println(rs.remove(1));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
    }
}

class RandomizedSet {
    private HashMap<Integer, Integer> map;

    public RandomizedSet() {
        HashMap<Integer, Integer> map = new HashMap<>();
        this.map = map;
    }

    public boolean insert(int val) {
        if (doesContain(val)) {
            return false;
        } else {
            map.put(val, val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (doesContain(val)) {
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int randomIndex = (int) (Math.random() * map.size());
        int i = 0;
        for (int key : map.keySet()) {
            if (i == randomIndex) {
                return key;
            }
            i++;
        }
        return -1;
    }

    private boolean doesContain(int val) {
        if (map.containsKey(val)) {
            return true;
        } else {
            return false;
        }
    }
}