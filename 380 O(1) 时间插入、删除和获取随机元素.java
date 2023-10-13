import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
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
    private List<Integer> list;

    public RandomizedSet() {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        this.map = map;
        this.list = list;
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            list.add(val);
            int indexInList = list.size() - 1;
            map.put(val, indexInList);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int indexInList = map.get(val);
            // list.remove(indexInList); // 这样写会导致后面的元素的indexInList都变了, 且时间复杂度为O(n)
            int lastElement = list.get(list.size() - 1);
            list.set(indexInList, lastElement); // 将最后一个元素复制到要删除的元素的位置上
            map.put(lastElement, indexInList); // 更新最后一个元素的indexInList
            list.remove(list.size() - 1); // 删除最后一个元素
            map.remove(val); // 删除要删除的元素
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int numOfElements = list.size();
//        int randomIndex = (int) (Math.random() * numOfElements);
        int randomIndex = new Random().nextInt(numOfElements);
        return list.get(randomIndex);
    }
}