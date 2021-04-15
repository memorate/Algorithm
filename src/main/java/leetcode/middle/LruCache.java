package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，
 * 并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * @author Anchor
 * @date 2021-04-15 14:58
 */
public class LruCache<K, V> {
    public static void main(String[] args) {
        LruCache<Integer, String> cache = new LruCache<>(2);
        System.out.println(cache.get(1));
        cache.put(1, "a");
        cache.put(2, "b");
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(3, "c");
        System.out.println(cache.get(1));
        cache.put(4, "d");
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        cache.put(3, "cc");
        System.out.println(cache.get(3));
    }

    private final int capacity;
    private final Node head;
    private final Node tail;
    private final Map<K, Node> map;

    public LruCache(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("LruCache capacity can not less or equal 0!");
        this.capacity = capacity;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>(capacity);
    }

    public V get(K key) {
        Node n = map.get(key);
        if (n == null) return null;
        moveToHead(n);
        return n.val;
    }

    public void put(K key, V val) {
        Node n = map.get(key);
        if (n == null) {
            n = new Node(key, val);
            addToHead(n);
            map.put(key, n);
        } else {
            n.val = val;
            moveToHead(n);
        }
        if (map.size() > capacity) {
            map.remove(tail.pre.key);
            removeNode(tail.pre);
        }
    }

    private void removeNode(Node n) {
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }

    private void addToHead(Node n) {
        n.pre = head;
        n.next = head.next;
        // 注意一下两行代码的顺序，反了会产生bug，think hard
        head.next.pre = n;
        head.next = n;
    }

    private void moveToHead(Node n) {
        removeNode(n);
        addToHead(n);
    }

    class Node {
        Node pre;
        Node next;
        K key;
        V val;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}
