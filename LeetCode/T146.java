import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * todo
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2020/5/25 9:24.
 */
public class T146 {
    public static void main(String[] args) {
        T146 mains = new T146(2);
        System.out.println(mains.get(2));
        mains.put(2,6);
        System.out.println(mains.get(1));
        mains.put(1,5);
        mains.put(1,2);
        System.out.println(mains.get(1));
        System.out.println(mains.get(2));

    }
    class LRU extends LinkedHashMap<Integer,Integer> {
        int c;
        public LRU(int capacity) {
            super((int) (capacity * 0.75), 0.75f, true);
            c = capacity;
        }
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return this.size() > c;
        }
    }
    private LRU a;
    public T146(int capacity) {
        a = new LRU(capacity);
    }

    public int get(int key) {
        return a.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        a.put(key, value);
    }

    class Prefer{

        class Node {
            int key;
            int value;
            Node next;
            Node prev;
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        Node head = new Node(-1, -1);
        Node tail = new Node(-2, -2);
        Map<Integer,Node> map;
        int capacity;
        public Prefer(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>((int) (capacity / 0.75F));
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node a = map.get(key);
            if(a == null) return -1;
            else {
                moveToTail(a);
            }
            return a.value;
        }

        public void put(int key, int value) {
            Node a = new Node(key, value);
            Node r = map.get(key);
            if(r != null) {
                r.value = value;
                moveToTail(r);
            }else {
                if(map.size() >= capacity) removeHead();
                insertTail(a);
                map.put(key, a);
            }
        }
        public void removeHead() {
            Node h = head.next;
            map.remove(h.key);
            head.next = h.next;
            h.next.prev = head;
        }
        public void insertTail(Node a) {
            Node tmp = tail.prev;
            tmp.next = a;
            a.prev = tmp;
            tail.prev = a;
            a.next = tail;
        }
        public void moveToTail(Node a) {
            Node tmp = a.prev;
            tmp.next = a.next;
            a.next.prev = tmp;
            insertTail(a);
        }
    }
}
