import leetCode.common.ListNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LeetCode {

    /**
     * 19
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int nodeSize = 0;
        ListNode node = head;
        while (node != null) {
            node = node.getNext();
            nodeSize++;
        }
        if (nodeSize == n) {
            return head.getNext();
        } else {
            ListNode preNode = head;
            for (int i = 0; i < nodeSize - n - 1; i++) {
                preNode = preNode.getNext();
            }
            ListNode deleteNode = preNode.getNext();
            ListNode afterNode = deleteNode.getNext();
            preNode.setNext(null);
            if (afterNode != null) {
                preNode.setNext(afterNode);
            }
            return head;
        }
    }

    public static void test19() {
        ListNode node = new ListNode(5, null);
        ListNode node1 = new ListNode(4, node);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(1, node3);
        ListNode result = removeNthFromEnd(node4, 2);
        System.out.println(result);
    }


    /**
     * 367
     */
    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int max = num;
        int min = 0;
        while (min < max - 1) {
            int mid = (min + max) / 2;
            long mul = (long) mid * mid;
            if (mul == num) {
                return true;
            }
            if (mul > num) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return false;
    }

    public static void test367() {
        System.out.println(isPerfectSquare(2147483647));
    }


    /**
     * 917
     */
    public static String reverseOnlyLetters(String s) {
        char[] array = s.toCharArray();
        int len = s.length();
        int start = 0;
        int end = len - 1;
        while (start < end) {
            char startValue = array[start];
            char endValue = array[end];
            //判断是否是字符
            boolean startIsChar = (startValue >= 65 && startValue <= 90) || (startValue >= 97 && startValue <= 122);
            boolean endIsChar = (endValue >= 65 && endValue <= 90) || (endValue >= 97 && endValue <= 122);
            //不是字符
            if (!startIsChar || !endIsChar) {
                if (!startIsChar) {
                    start++;
                }
                if (!endIsChar) {
                    end--;
                }
                continue;
            }
            //都是字符
            array[end] = startValue;
            array[start] = endValue;
            start++;
            end--;
        }
        return new String(array);
    }


    public static void test917() {
        System.out.println("result = " + reverseOnlyLetters("a-bC-dEf-ghIj"));
    }


    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {
        int num = 917;
        Class leetCodeClass = LeetCode.class;
        try {
            Method method = leetCodeClass.getMethod("test" + num);
            try {
                method.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
