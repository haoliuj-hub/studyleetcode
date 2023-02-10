package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Test {

    static Map<Integer, String> result = new ConcurrentHashMap<>();

    // 构造线程池
    static ThreadPoolExecutor leftExecutor = new ThreadPoolExecutor(8, 30, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    // 构造线程池
    static ThreadPoolExecutor rightExecutor = new ThreadPoolExecutor(8, 30, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    private static String[] operators = {
            "0", "1", "2", "3"
    };

    private Map<Integer, List<String>> mapLeft = new HashMap<>();
    private Map<Integer, List<String>> mapRight = new HashMap<>();
    // 阻塞队列
    private BlockingQueue<List<String>> result2 = new LinkedBlockingQueue();

    public static void main(String[] args) {
        Test test = new Test();
        CountDownLatch count = new CountDownLatch(1);
        int[] nums = {8,0,8,3,4,8,7,8,6,4,8,0,5,4,2,8};

        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());

        test.search(collect, 4477488, 1, count);
    }


    public void search(List<Integer> nums, int target, Integer index, CountDownLatch count) {
        long start = System.currentTimeMillis();
        System.out.println(nums);
        int i = nums.size() / 2;
        List<Integer> left = nums.subList(0, i + 1);
        List<Integer> right = new ArrayList<>();
        right.add(target);
        List<Integer> others = new ArrayList<>(nums.subList(i + 1, nums.size()));
        Collections.reverse(others);
        right.addAll(others);
        System.out.println(nums);


        leftExecutor.execute(() -> {
            calLeft(0, left, null, new ArrayList<>());
        });
        rightExecutor.execute(() -> {
            calRight(0, right, null, new ArrayList<>());
        });

        try {
            List<String> expression = result2.take();

            String join = String.join("", expression);
            result.put(index, join);
            count.countDown();
            System.out.println(expression);

            StringBuffer buffer = new StringBuffer();
            int next = nums.get(0);
            buffer.append(next);
            for (int z = 1; z < nums.size(); z++) {
                switch (expression.get(z - 1)) {
                    case "0":
                        next = next + nums.get(z);
                        buffer.append("+");
                        break;
                    case "1":
                        next = next - nums.get(z);
                        buffer.append("-");
                        break;
                    case "2":
                        next = next * nums.get(z);
                        buffer.append("*");
                        break;
                    case "3":
                        next = next / nums.get(z);
                        buffer.append("/");
                        break;
                    default:
                }
                buffer.append(nums.get(z));
            }

            System.out.println(buffer.toString());
            System.out.println(next);


            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void calRight(int total, List<Integer> end, String c, List<String> expression) {
        if (result2.size() > 0) {
            return;
        }

        int now = end.get(0);
        int nowTotal;
        ArrayList<String> strings = new ArrayList<>(expression);
        if (c != null) {
            switch (c) {
                case "0":
                    nowTotal = total + now;
                    strings.add("1");
                    break;
                case "1":
                    nowTotal = total - now;
                    strings.add("0");
                    break;
                case "2":
                    nowTotal = total * now;
                    strings.add("3");
                    break;
                case "3":
                    if (total != 0 && now == 0) {
                        return;
                    }
                    if (total == 0 && now == 0) {
                        strings.add("2");
                        for (int i = 0; i < end.size() - 1; i++) {
                            strings.add("0");
                        }
                        ArrayList<String> strings1 = new ArrayList<>(strings);
                        Collections.reverse(strings1);
                        if(mapLeft.size() > 1){
                            List<String> leftExpression = null;
                            Set<Integer> integers = mapLeft.keySet();
                            for(Integer key : integers){
                                leftExpression =mapLeft.get(key);
                                break;
                            }
                            leftExpression.addAll(strings1);
                            result2.add(leftExpression);
                            return;
                        }
                        mapRight.put(0, strings1);
                        return;
                    }
                    if (total % now == 0) {
                        nowTotal = total / now;
                        strings.add("2");
                    } else {
                        return;
                    }
                    break;
                default:
                    return;
            }

            if (end.size() == 1) {
                ArrayList<String> strings1 = new ArrayList<>(strings);
                Collections.reverse(strings1);
                if (mapLeft.containsKey(nowTotal)) {
                    List<String> leftExpression = mapLeft.get(nowTotal);
                    leftExpression.addAll(strings1);
                    result2.add(leftExpression);
                    return;
                }
                mapRight.put(nowTotal, strings1);
                return;
            }
        } else {
            nowTotal = now;
        }

        for (int i = 0; i < operators.length; i++) {
            calRight(nowTotal, end.subList(1, end.size()), operators[i], strings);
        }

    }

    public void calLeft(int total, List<Integer> end, String c, List<String> expression) {
        if (result2.size() > 0) {
            return;
        }

        int now = end.get(0);
        int nowTotal;
        ArrayList<String> strings = new ArrayList<>(expression);
        if (c != null) {
            strings.add(c);
            switch (c) {
                case "0":
                    nowTotal = total + now;
                    break;
                case "1":
                    nowTotal = total - now;
                    break;
                case "2":
                    nowTotal = total * now;
                    break;
                case "3":
                    if (now == 0) {
                        return;
                    }
                    if (total % now == 0) {
                        nowTotal = total / now;
                    } else {
                        return;
                    }
                    break;
                default:
                    return;
            }

            if (end.size() == 1) {
                if (mapRight.containsKey(nowTotal)) {
                    List<String> rightExpression = mapRight.get(nowTotal);
                    strings.addAll(rightExpression);
                    result2.add(strings);
                    return;
                }
                mapLeft.put(nowTotal, strings);
                return;
            }
        } else {
            nowTotal = now;
        }

        for (int i = 0; i < operators.length; i++) {
            calLeft(nowTotal, end.subList(1, end.size()), operators[i], strings);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}