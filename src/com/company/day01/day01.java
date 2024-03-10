package com.company.day01;

import com.company.entity.ListNode;

import java.util.*;

public class day01 {

    /*
    给你一个字符串 s，找到 s 中最长的回文子串。
    如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

    输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
     */
    public String longestPalindrome1(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        int strLen=s.length();
        int left=0;
        int right=0;
        int len=1;
        int maxStart=0;
        int maxLen=0;
        for (int i=0;i<strLen;i++){
            left=i-1;
            right=i+1;
            while(left>=0&&s.charAt(i)==s.charAt(left)){
                len++;
                left--;
            }
            while (right<s.length()&&s.charAt(right)==s.charAt(i)){
                len++;
                right++;
            }
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                len+=2;
                left--;
                right++;
            }
            if (len>maxLen){
                maxLen=len;
                maxStart=left;
            }
            len=1;
        }
        return s.substring(maxStart+1,maxStart+maxLen+1);
    }

    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     *
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String convert(String s, int numRows) {
        if (numRows<2) return s;
        List<StringBuilder> rows=new ArrayList<>();
        for (int i=0;i<numRows;i++){
            rows.add(new StringBuilder());
        }
        int i=0,flag=-1;
        for (char c:s.toCharArray()){
            rows.get(i).append(c);
            if (i==0||i==numRows-1){
                flag=-flag;
            }
            i+=flag;
        }
        StringBuilder res=new StringBuilder();
        for (StringBuilder str:rows){
            res.append(str);
        }
        return res.toString();
    }


    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     *
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     *
     * 输入：x = 123
     * 输出：321
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int reverse(int x) {
        String s = String.valueOf(x);
        String c="";
        int len=s.length();
        for (int i=len-1;i>=0;i--){
            c+=s.charAt(i);
        }
        return Integer.valueOf(c);
    }

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     *
     * 说明：你不能倾斜容器。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxArea(int[] height) {
        if (height.length<=1){
            return 0;
        }
        int max=0;
        for (int i=0;i<height.length;i++){
            for (int j=height.length-1;j>i;j--){
                int a=Math.min(height[i],height[j]);
                max=Math.max(max,a*(j-i));
            }
        }
        return max;
    }

    /**
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给你一个整数，将其转为罗马数字。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/integer-to-roman
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<values.length;i++){
            while(num>=values[i]){
                sb.append(rom[i]);
                num-=values[i];
            }
        }
        return sb.toString();
    }


    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/roman-to-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String a=strs[0];
        for(int i=1;i<strs.length;i++){
            a=bijiao(a,strs[i]);
        }
        return a;
    }
    public String bijiao(String a,String b){
        int len=Math.min(a.length(),b.length());
        int m=0;
        for (int i=0;i<len;i++){
            if (a.charAt(i)!=b.charAt(i)){
                m=i;
            }
        }
        return a.substring(0,m);
    }

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * 你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 示例 1：
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists=new ArrayList<>();
        if (nums.length==3){
            if (nums[0]+nums[1]+nums[2]==0){
                List<Integer> list=new ArrayList<>();
                list.add(nums[0]);
                list.add(nums[1]);
                list.add(nums[2]);
                lists.add(list);
            }
            return null;
        }

        for (int a=0;a<nums.length-2;a++){
            for (int b=a+1;b<nums.length-1;b++){
                for (int c=b+1;c<nums.length;c++){
                    if (nums[a]+nums[b]+nums[c]==0){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        lists.add(list);

                    }
                }
            }
        }
        return lists;
    }

    /**
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     *
     * 返回这三个数的和。
     *
     * 假定每组输入只存在恰好一个解。
     *
     * 示例 1：
     *
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret=nums[0]+nums[1]+nums[2],n=nums.length;
        for (int i=0;i<n-2;i++){
            int l=i+1,r=n-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if (sum==target){
                    return target;
                }
                if (sum<target){
                    l++;
                }else {
                    r--;
                }
                if (Math.abs(ret - target) > Math.abs(sum - target)) {
                    ret = sum;
                }
            }
        }
        return ret;
    }

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;

    }
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValid(String s) {
        int n=s.length();
        if (n%2==1){
            return false;
        }
        Map<Character,Character> pairs=new HashMap<>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack=new LinkedList<>();
        for (int i=0;i<n;i++){
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)){
                if (stack.isEmpty()||stack.peek()!=pairs.get(ch)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1=new ListNode(0,list1);
        ListNode l2=new ListNode(0,list2);
        ListNode l3=new ListNode(0);
        while(l1!=null&&l2!=null){
            if (l1==null){
                l3.next=l2;
            }
            if (l2==null){
                l3=l1;
            }
            if (l1.next.val<l2.next.val){
                l3.next=l1;
                l1=l1.next;
            }
            if (l1.next.val>=l2.next.val){
                l3.next=l2;
                l2=l2.next;
            }
        }
        return l3;
    }

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     */
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> a=new ArrayList<>();
        for (ListNode l:lists){
            ListNode l1=new ListNode(0,l);
            while(l1!=null){
                a.add(l.next.val);
                l=l.next;
            }
        }
        Integer[] b =(Integer[]) a.toArray();
        Arrays.sort(b);
        ListNode c=new ListNode(b[0]);
        for (int i=1;i<b.length;i++){
            ListNode d=new ListNode(b[i]);
            c.next=d;
        }
        return c;
    }
}
