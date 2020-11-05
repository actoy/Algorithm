package com.datastructure;

/**
 *  * 实例TrieTree
 *  *
 *  * @version 1.0
 *  
 */
public class TrieTree {
    public static class Node1 {
        //通过该节点的次数
        public int pass;
        //以该节点结尾的次数
        public int end;
        public Node1[] nexts;
        //如果的字符不是字母，Interger存储ascii码，即(int) char[i]
        //public HashMap<Interger, Node1> nexts;

        public Node1() {
            pass = 0;
            end = 0;
            // a - z 26个英文字母及0 - 25，默认都为null
            // nexts[i] = null   i方向的路不存在
            // nexts[i] != null  i方向的路存在
            nexts = new Node1[26];
        }
    }

    public static class Trie1 {
        private Node1 root;

        public Trie1() {
            root = new Node1();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chars.length; ++i) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node1();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                Node1 node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chars.length; ++i) {
                    index = chars[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < chars.length; ++i) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        // 所加入的字符创中，有几个字符串以pre开头
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chars = pre.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < chars.length; ++i) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;

        }
    }

}
