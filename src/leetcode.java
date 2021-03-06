import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class TestingAlog {
    @Test
    public void runSolution() {
        //String[] s = {"XXX", "OOO"};//{"XOOXXXOO", "OOOOXOXX", "XXOXXOOO", "OXOOOXXX", "OOXXXXOX", "XOXXXOXO", "OOOXOXOX", "XOXXOXOX"};
        System.out.println(maxSubArray(new int[]{0,2,3,-2,-4}));
    }

    public int maxSubArray(int[] nums) {
        int maxSum = 0;
        
        return maxSum;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (true) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
    }

    private boolean isBadVersion(int val) {
        return val == 1;
    }

    //Toptal Live Coding round - 15 mins
    void solution(String[] mines) {

        char[][] matrix = new char[mines.length][mines[0].length()];
        String[][] output = new String[mines.length][mines[0].length()];
        for (int i = 0; i < mines.length; i++) {
            matrix[i] = mines[i].toCharArray();
        }

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {

                if (matrix[i][j] == 'X') {
                    output[i][j] = "X";
                    continue;
                }

                int count = 0;

                //left top corner
                if (i > 0 && j > 0) {
                    if (matrix[i - 1][j - 1] == 'X') {
                        count++;
                    }
                }

                //top
                if (i > 0) {
                    if (matrix[i - 1][j] == 'X') {
                        count++;
                    }
                }

                //right
                if (j < output[0].length - 1) {
                    if (matrix[i][j + 1] == 'X') {
                        count++;
                    }
                }

                //right top
                if (j < output[0].length - 1 && i > 0) {
                    if (matrix[i - 1][j + 1] == 'X') {
                        count++;
                    }
                }

                // right bottom
                if (j < output[0].length - 1 && i < output.length - 1) {
                    if (matrix[i + 1][j + 1] == 'X') {
                        count++;
                    }
                }

                //bottom
                if (i < output.length - 1) {
                    if (matrix[i + 1][j] == 'X') {
                        count++;
                    }
                }

                //left bottom
                if (j > 0 && i < output.length - 1) {
                    if (matrix[i + 1][j - 1] == 'X') {
                        count++;
                    }
                }

                // left
                if (j > 0) {
                    if (matrix[i][j - 1] == 'X') {
                        count++;
                    }
                }

                output[i][j] = String.valueOf(count);
            }
        }

        for (String[] row : output) {
            System.out.println(Arrays.toString(row));
        }
    }

    public boolean checkStraightLine(int[][] coordinates) {
        // 0 1 2
        int angle = 0;
        // use
        for (int cordinateIndex = 0; cordinateIndex < coordinates.length - 1; cordinateIndex++) {
            int[] firstPoint = coordinates[cordinateIndex];
            int[] secondPoint = coordinates[cordinateIndex + 1];
            if (cordinateIndex == 0) {
                //store the first angle
                if (secondPoint[0] == firstPoint[0]) {
                    //angle will be infite
                    angle = Integer.MAX_VALUE;
                } else {
                    angle = (secondPoint[1] - firstPoint[1]) / (secondPoint[0] - firstPoint[0]);
                }
                System.out.println("First angle: " + angle);
            } else {
                if (angle == Integer.MAX_VALUE) {
                    if (secondPoint[0] != firstPoint[0]) {
                        System.out.println("Point not in same line");
                        return false;
                    }
                } else {
                    if ((Math.abs(secondPoint[1] - firstPoint[1])) / Math.max(1, Math.abs(secondPoint[0] - firstPoint[0])) != angle) {
                        System.out.println("Point not in same line");
                        return false;
                    }
                }
                System.out.println("Point in same line");
            }
        }
        System.out.println("All Points are in the same line");
        return true;
    }

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int subLen = 1; subLen <= len / 2; subLen++) {
            if (len % subLen != 0) {
                continue;
            }
            //start matching
            int repeatitionTime = len / subLen;
            StringBuilder stringBuilder = new StringBuilder();
            String subString = s.substring(0, subLen);
            while (repeatitionTime > 0) {
                stringBuilder.append(subString);
                repeatitionTime--;
            }
            if (stringBuilder.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // take a rectangle say rec1
        // get all its point and check which corner falls into other rectangle
        //first corner
        int blx = rec1[0];
        int bly = rec1[1];

        int rtx = rec1[2];
        int rty = rec1[3];

        int rbx = rtx;
        int rby = bly;

        int ltx = blx;
        int lty = rty;

        return false;
    }

    private boolean pointInside(int[] rec, int x, int y) {
        int rectX1 = rec[0];
        int rectX2 = rec[2];
        int rectY1 = rec[1];
        int rectY2 = rec[3];

        return x > rectX1 && x < rectX2 && y > rectY1 && y < rectY2;
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n > 2) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                return false;
            }
        }
        return true;
    }

    //2, 3, 7
    int getMinimumChange(int amount) {
        int[] dp = new int[amount + 1];
        int[] coins = new int[3];
        // 0 - 2
        // 1 - 3
        // 2 - 7
        Arrays.fill(dp, -1);
        System.out.println("For " + amount);
        int minChange = minChange(dp, coins, amount);
        System.out.println(" [7] x " + coins[2] + " = " + (7 * coins[2]));
        System.out.println(" [3] x " + coins[1] + " = " + (3 * coins[1]));
        System.out.println(" [2] x " + coins[0] + " = " + (2 * coins[0]));
        return minChange;
    }

    int minChange(int[] dp, int[] coins, int remaining) {
        if (remaining < 0) {
            return 0;
        }
        if (remaining == 7) {
            coins[2]++;
            return 1;
        }
        if (remaining == 3) {
            coins[1]++;
            return 1;
        }
        if (remaining == 2) {
            coins[0]++;
            return 1;
        }

        if (dp[remaining] != -1) {
            return dp[remaining];
        }

        //first try with largets coin
        int using7 = minChange(dp, coins, remaining - 7);
        if (using7 != 0) {
            dp[remaining] = 1 + using7;
            coins[2]++;
            return dp[remaining];
        } else {
            int using3 = minChange(dp, coins, remaining - 3);
            if (using3 != 0) {
                dp[remaining] = 1 + using3;
                coins[1]++;
                return dp[remaining];
            } else {
                int using2 = minChange(dp, coins, remaining - 2);
                if (using2 != 0) {
                    dp[remaining] = 1 + using2;
                    coins[0]++;
                    return dp[remaining];
                }
            }
        }
        return dp[remaining] = 0;
    }

    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int totalRabits = 0;
        for (int n : answers) {
            int rabits = n + 1;
            if (rabits == 1) {
                totalRabits++;
                continue;
            }
            if (!map.containsKey(rabits)) {
                totalRabits += rabits;
                map.put(rabits, 1);
            }
        }
        return totalRabits;
    }

    public int maxOperations(int[] nums, int k) {
        int ops = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //check if this can be nulify other
            if (map.containsKey(k - nums[i])) {
                //don`t add this, and also reduce count of the other pair
                if (map.get(k - nums[i]) == 1) {
                    map.remove(k - nums[i]);
                } else {
                    map.put(k - nums[i], map.get(k - nums[i]) - 1);
                }
                ops++;
            } else {
                //add it to map
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return ops;
    }

    public int findLength(int[] A, int[] B) {
        int maxSeries = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] != B[j])
                    continue;

                int tempSeries = 0;
                int fp = i;
                int sp = j;
                while (fp < A.length && sp < B.length && A[fp] == B[sp]) {
                    tempSeries++;
                    fp++;
                    sp++;
                }
                maxSeries = Math.max(maxSeries, tempSeries);
            }
        }
        maxSeries = Math.max(0, maxSeries);
        return maxSeries;
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        //{
        //  TableNum : {
        //                  Item : Count
        //  }
        //}
        //
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        Set<String> distinctItems = new HashSet<>();
        for (List<String> order : orders) {
            String tableNumber = order.get(1);
            String itemName = order.get(2);
            distinctItems.add(itemName);
            HashMap<String, Integer> item = map.getOrDefault(tableNumber, new HashMap<>());
            item.put(itemName, item.getOrDefault(itemName, 0) + 1);
            map.put(tableNumber, item);
        }
        List<List<String>> orderList = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        for (Iterator<String> it = distinctItems.iterator(); it.hasNext(); ) {
            String item = it.next();
            header.add(item);
        }
        orderList.add(header);
        ArrayList<String> row;
        for (Map.Entry<String, HashMap<String, Integer>> entry : map.entrySet()) {
            row = new ArrayList<>();
            String tableNum = entry.getKey();
            HashMap<String, Integer> ordermap = entry.getValue();
            row.add(tableNum);
            for (Iterator<String> it = distinctItems.iterator(); it.hasNext(); ) {
                String item = it.next();
                row.add(String.valueOf(ordermap.getOrDefault(item, 0)));
            }
            orderList.add(row);
        }
        return orderList;
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        int count[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (count[i] != 0)
                return false;
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }
        return false;
    }

    public int leastBricks(List<List<Integer>> wall) {
        int height = wall.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        int aggregateSum;
        int maxAggregateSum = 0;
        for (int row = 0; row < height; row++) {
            aggregateSum = 0;
            for (int brickIndex = 0; brickIndex < wall.get(row).size(); brickIndex++) {
                aggregateSum += wall.get(row).get(brickIndex);
                map.put(aggregateSum, map.getOrDefault(aggregateSum, 0) + 1);
                maxAggregateSum = Math.max(maxAggregateSum, aggregateSum);
            }
        }
        System.out.println(map);
        int maxEntriesBreaksAt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() < maxAggregateSum) {
                maxEntriesBreaksAt = Math.max(maxEntriesBreaksAt, entry.getValue());
            }
        }
        return wall.size() - maxEntriesBreaksAt;
    }

    public boolean isValidSudoku(char[][] board) {
        boolean isValid = true;
        //horizontals
        Set<Character> set = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            set.clear();
            for (int column = 0; column < 9; column++) {
                char ch = board[row][column];
                if (ch == '.')
                    continue;

                if (set.contains(ch)) {
                    return false;
                }

                set.add(ch);
            }
        }

        //verticals
        for (int column = 0; column < board.length; column++) {
            set.clear();
            for (int row = 0; row < 9; row++) {
                char ch = board[row][column];
                if (ch == '.')
                    continue;

                if (set.contains(ch)) {
                    return false;
                }
                set.add(ch);
            }
        }

        //check box
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set.clear();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int indexX = i * 3;
                        int indexY = j * 3;
                        int x = indexX + k;
                        int y = indexY + l;

                        char ch = board[y][x];
                        if (ch == '.')
                            continue;
                        if (set.contains(ch)) {
                            return false;
                        }
                        set.add(ch);
                    }
                }
            }
        }

        return isValid;
    }

    int solution(int[] a, int S) {
        int totalWays = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            int expectedSum = 0;
            for (int j = i; j < a.length; j++) {
                expectedSum += S;
                sum += a[j];
                if (expectedSum == sum) {
                    totalWays++;
                    expectedSum = 0;
                    sum = 0;
                }
            }
        }
        return totalWays;
    }

    //MXPlayer Question : Medium (10 Marks)
    public static String ArrayChallenge(String[] strArr) {
        //"11:30AM-12:45PM","12:50PM-03:30PM","08:00PM-09:00PM"
        Date[][] times = new Date[strArr.length][2];
        SimpleDateFormat ft = new SimpleDateFormat("hh:mma");
        int i = 0;
        for (String s : strArr) {
            String[] startEnd = s.split("-");
            try {
                times[i][0] = ft.parse(startEnd[0]);
                times[i++][1] = ft.parse(startEnd[1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Arrays.sort(times, (o1, o2) -> (int) (o1[0].getTime() - o2[0].getTime()));
        long maxGap = Integer.MIN_VALUE;
        // code goes here
        for (i = 0; i < times.length - 1; i++) {
            Date prevEnd = times[i][1];
            Date nextStart = times[i + 1][0];
            maxGap = Math.max(maxGap, nextStart.getTime() - prevEnd.getTime());
        }
        long totalMins = maxGap / (1000 * 60);
        long hour = totalMins / 60;
        long min = totalMins % 60;
        return String.format("%02d:%02d", hour, min);
    }

    //MXPlayer : Hard (15 Marks)
    public String GameChallenge(String[] strArr) {
        //strArr = new String[]{"X","O","-","<>","X","O","-","<>","X","O","-","<>"};
        int[][] allCells = {
                {0, 1, 2},
                {4, 5, 6},
                {8, 9, 10},
                {0, 4, 8},
                {1, 5, 9},
                {2, 6, 10},
                {2, 5, 8},
                {0, 5, 10}
        };

        int xCount;
        int zCount;
        int emptyIndex;
        for (int i = 0; i < allCells.length; i++) {
            xCount = 0;
            zCount = 0;
            emptyIndex = -1;
            for (int j = 0; j < 3; j++) {
                //try matching each row
                if (strArr[allCells[i][j]] == "X") {
                    xCount++;
                } else if (strArr[allCells[i][j]] == "O") {
                    zCount++;
                } else {
                    emptyIndex = allCells[i][j];
                }
                if ((xCount == 2 || zCount == 2) && emptyIndex != -1) {
                    return String.valueOf(emptyIndex);
                }
            }
        }
        // code goes here
        return strArr[0];
    }

    //MXPlayer : Medium (10 Marks)
    public String SearchingChallenge(String str) {
        //str "(code)(byte]"
        Stack<Character> stack = new Stack<>();
        int matchCount = 0;
        for (char bracket : str.toCharArray()) {
            if (bracket == '(' || bracket == '[') {
                stack.push(bracket);
            }
            if (bracket == ']') {
                //pop 1 bracket and match
                char poppedBracket = stack.pop();
                if (poppedBracket == '[') {
                    matchCount++;
                } else {
                    return "0";
                }
            } else if (bracket == ')') {
                //pop 1 bracket and match
                char poppedBracket = stack.pop();
                if (poppedBracket == '(') {
                    matchCount++;
                } else {
                    return "0";
                }
            }
        }
        // code goes here
        return "1 " + matchCount;
    }

    public String FindIntersection(String[] strArr) {
        String[] firstStrArr = strArr[0].split(", ");
        String[] secondStrArr = strArr[1].split(", ");
        int[] firstArr = new int[firstStrArr.length];
        int[] secondArr = new int[secondStrArr.length];

        int i = 0;
        for (String s : firstStrArr) {
            firstArr[i++] = Integer.parseInt(s);
        }

        i = 0;
        for (String s : secondStrArr) {
            secondArr[i++] = Integer.parseInt(s);
        }

        int firstPointer = 0;
        int secondPointer = 0;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (firstPointer < firstArr.length && secondPointer < secondArr.length) {
            if (firstArr[firstPointer] == secondArr[secondPointer]) {
                if (i > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(firstArr[firstPointer]);
                i++;
                firstPointer++;
                secondPointer++;
            } else if (firstArr[firstPointer] > secondArr[secondPointer]) {
                secondPointer++;
            } else {
                firstPointer++;
            }
        }
        return stringBuilder.toString();
    }

    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char ch : tasks) {
            counts[ch - 65]++;
        }

        //Pair => Character : Count
        Queue<int[]> taskQueue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                taskQueue.add(new int[]{i + 65, counts[i]});
            }
        }

        int totalLength = 0;
        int currentIndexInNewTasks = 0;
        int[] lastUsed = new int[26];
        Arrays.fill(lastUsed, Integer.MIN_VALUE);

        while (!taskQueue.isEmpty()) {
            int[] task = taskQueue.peek();
            if (lastUsed[task[0] - 65] + n >= currentIndexInNewTasks) {
                //we need to insert the idle part here
                int idlingCount = 1 + n + lastUsed[task[0] - 65] - currentIndexInNewTasks;
                while (idlingCount > 0) {
                    System.out.print("-[IDLE]-");
                    totalLength++;
                    currentIndexInNewTasks++;
                    idlingCount--;
                }
            } else {
                task = taskQueue.poll();
                System.out.print("-[" + (char) task[0] + "]-");
                lastUsed[task[0] - 65] = currentIndexInNewTasks;
                if (task[1] > 1) {
                    taskQueue.add(new int[]{task[0], task[1] - 1});
                }
                totalLength++;
                currentIndexInNewTasks++;
            }
        }
        return totalLength;
    }

    private boolean elementsLeft(int[] counts) {
        for (int count : counts) {
            if (count > 0)
                return true;
        }
        return false;
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int finalRotation = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, finalRotation - 1);
        reverse(nums, finalRotation, len - 1);
    }

    void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int t = arr[end];
            arr[end] = arr[start];
            arr[start] = t;
            start++;
            end--;
        }
    }

    public int[] rotateArr(int[] nums, int k) {
        int len = nums.length;
        int finalRotation = k % len;
        int[] rotatedArr = new int[nums.length];
        int startIndex = len - finalRotation;
        int rIndex = 0;
        while (rIndex < nums.length) {
            rotatedArr[rIndex++] = nums[startIndex];
            startIndex++;
            if (startIndex >= len) {
                startIndex %= len;
            }
        }
        return rotatedArr;
    }

    public int maxDistToClosest(int[] seats) {
        int maxEmptySeq = Integer.MIN_VALUE;
        int leftIndex;
        int rightIndex;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                int ri = i;
                while (ri < seats.length && seats[ri] == 0) {
                    ri++;
                }
                leftIndex = i;
                rightIndex = ri;
                int newSeq = (leftIndex == 0 || rightIndex > seats.length - 1) ? 1 + 2 * (ri - i - 1) : ri - i;
                maxEmptySeq = Math.max(maxEmptySeq, newSeq);
                i = ri;
            }
        }
        System.out.println(maxEmptySeq);
        if (maxEmptySeq % 2 == 0) {
            return maxEmptySeq / 2;
        }
        return 1 + maxEmptySeq / 2;
    }

    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for (int[] arr : visited) {
            Arrays.fill(arr, -1);
        }
        char[] wordChars = word.toCharArray();
        //check for each cell we can start with
        boolean matching;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (wordChars[0] == board[i][j]) {
                    matching = matchingAt(board, visited, j, i, wordChars, 0);
                    if (matching) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean matchingAt(char[][] board, int[][] visited, int x, int y, char[] word,
                       int characterIndex) {
        if (x < 0 || x >= board[0].length || y < 0 || y >= board.length) {
            return false;
        }

        if (visited[y][x] != -1) {
            return false;
        }

        if (board[y][x] == word[characterIndex]) {
            //move ahead
            //1. mark cell as visited
            visited[y][x] = 1;
            //check if word has ended
            if (characterIndex == word.length - 1) {
                System.out.println("Last match " + word[characterIndex] + " at [" + x + "," + y + "]");
                return true;
            }
            //try move in all the direction

            //left
            boolean furtherLeftMatching = matchingAt(board, visited, x - 1, y, word, characterIndex + 1);
            if (furtherLeftMatching) {
                System.out.println("match " + word[characterIndex] + " at [" + x + "," + y + "]");
                return true;
            }

            //right
            boolean furtherRightMatching = matchingAt(board, visited, x + 1, y, word, characterIndex + 1);
            if (furtherRightMatching) {
                System.out.println("match " + word[characterIndex] + " at [" + x + "," + y + "]");
                return true;
            }

            //bottom
            boolean furtherBottomMatching = matchingAt(board, visited, x, y + 1, word, characterIndex + 1);
            if (furtherBottomMatching) {
                System.out.println("match " + word[characterIndex] + " at [" + x + "," + y + "]");
                return true;
            }

            //bottom
            boolean furtherTopMatching = matchingAt(board, visited, x, y - 1, word, characterIndex + 1);
            if (furtherTopMatching) {
                System.out.println("match " + word[characterIndex] + " at [" + x + "," + y + "]");
                return true;
            }

            //reset visiting cell
            visited[y][x] = -1;
        }
        return false;
    }

    void sortColors(int[] colors) {
        int[] count = new int[3];
        for (int color : colors) {
            count[color]++;
        }
        int color = 0;
        while (count[color] == 0) {
            color++;
        }
        for (int i = 0; i < colors.length; i++) {
            while (count[color] <= 0) {
                color++;
            }
            colors[i] = color;
            count[color]--;
        }
    }

    int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flights = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0]; i <= booking[1]; i++) {
                flights[i - 1] += booking[2];
            }
        }
        return flights;
    }

    int minJump(int[] steps) {
        int[] dp = new int[steps.length];
        Arrays.fill(dp, -1);
        return minFrom(dp, steps, 0);
    }

    int minFrom(int[] dp, int[] steps, int startIndex) {
        if (startIndex >= steps.length - 1) {
            return 0;
        }

        if (dp[startIndex] != -1) {
            return dp[startIndex];
        }

        int min = 100001;
        int lastIndex = Math.min(steps.length - 1, steps[startIndex]);
        for (int jump = 1; jump <= lastIndex; jump++) {
            min = Math.min(min, 1 + minFrom(dp, steps, startIndex + jump));
        }
        return dp[startIndex] = min;
    }


    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return waysToClimbFrom(0, dp, n);
    }

    int waysToClimbFrom(int start, int[] dp, int N) {
        if (start == N) {
            return 1;
        }
        if (start > N) {
            return 0;
        }

        if (dp[start] != -1)
            return dp[start];

        int way1 = waysToClimbFrom(start + 1, dp, N);
        int way2 = waysToClimbFrom(start + 2, dp, N);
        return dp[start] = way1 + way2;
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int row = 0; row < A.length; row++) {
            //flip row and invert too
            int left = 0;
            int right = A[0].length - 1;
            int temp;
            while (left <= right) {
                //swap left & right and invert
                temp = A[row][left];
                A[row][left] = A[row][right] ^ 1;
                A[row][right] = temp ^ 1;
                left++;
                right--;
            }
        }
        return A;
    }

    public int findSpecialInteger(int[] arr) {
        int[] counts = new int[100001];
        // i index represent number  - i
        int maxCount = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int n : arr) {
            counts[n]++;
            if (maxCount < counts[n]) {
                maxCount = counts[n];
                maxValue = n;
            }
        }
        return maxValue;
    }

    public boolean canJump(int[] nums) {
        //dp[i] user can reach end from i`th index
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return canReachEnd(dp, nums, 0);
    }

    private boolean canReachEnd(int[] dp, int[] nums, int index) {
        if (index >= nums.length - 1) {
            return true;
        }

        if (dp[index] != -1) {
            //1 - true, 0 - false
            return dp[index] == 1;
        }

        dp[index] = 0;
        for (int i = 1; i <= nums[index]; i++) {
            int cr = canReachEnd(dp, nums, index + i) ? 1 : 0;
            if (cr == 1) {
                dp[index] = 1;
            }
        }
        return dp[index] == 1;
    }


    public int longestArithSeqLength(int[] A) {
        int longest = 0;
        // 1 99 88 77 2 4 3 7 5 11 6
        for (int i = 0; i < A.length - 1; i++) {
            int step;
            for (int j = i + 1; j < A.length; j++) {
                step = A[j] - A[i];
                int seq = 2;
                int movingIndex = j + 1;
                int lastNum = A[j];
                while (movingIndex < A.length) {
                    if (A[movingIndex] - lastNum == step) {
                        lastNum = A[movingIndex];
                        seq++;
                    }
                    movingIndex++;
                }
                longest = Math.max(seq, longest);
            }
        }
        return longest;
    }

    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        //num : divisors
        HashMap<Integer, Integer> divisors = new HashMap<>();
        //num : divs sum
        HashMap<Integer, Integer> sums = new HashMap<>();

        for (int num : nums) {
            int divisorsFound = 0;
            int tempSum = 1 + num;
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    tempSum += j;
                    divisorsFound++;
                    if (divisorsFound > 2) {
                        break;
                    }
                }
            }

            if (divisorsFound == 2) {
                totalSum += tempSum;
            }
        }
        return totalSum;
    }

    List<String> getIps(String ipString) {
        List<String> list = new ArrayList<>();
        for (int fss = 1; fss < 4; fss++) {
            for (int sss = 1; sss < 4; sss++) {
                for (int tss = 1; tss < 4; tss++) {
                    for (int lss = 1; lss < 4; lss++) {
                        if (fss + sss + tss + lss > ipString.length())
                            break;
                        //first
                        String fs = ipString.substring(0, fss);
                        int fi = Integer.parseInt(fs);
                        if (isValid(fs, fi)) {
                            //second
                            String ss = ipString.substring(fss, fss + sss);
                            int si = Integer.parseInt(ss);
                            if (isValid(ss, si)) {
                                //third
                                String ts = ipString.substring(fss + sss, fss + sss + tss);
                                int ti = Integer.parseInt(ts);
                                if (isValid(ts, ti)) {
                                    //fourth
                                    String ls = ipString.substring(fss + sss + tss, fss + sss + tss + lss);
                                    String truncatingString = ipString.substring(fss + sss + tss + lss);
                                    int li = Integer.parseInt(ls);
                                    if (ls.length() < 4 && truncatingString.length() == 0) {
                                        if (isValid(ls, li)) {
                                            list.add(fs + "." + ss + "." + ts + "." + ls);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //010010
                }
            }
        }
        return list;
    }

    private boolean isValid(String fs, int fi) {
        return (fi < 256 && String.valueOf(fi).length() == fs.length());
    }


    static int getMinG(String[] goodies, int H, int T) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int totalGoodies = 0;
        for (int i = 0; i < T; i++) {
            min = Math.min(Integer.parseInt(goodies[i]), min);
            max = Math.max(Integer.parseInt(goodies[i]), max);
            totalGoodies += Integer.parseInt(goodies[i]);
        }

        int leftEnd = min;
        int rightEnd = max;

        while (leftEnd < rightEnd) {
            int mid = leftEnd + (rightEnd - leftEnd) / 2;
            //try with mid
            int leftHours = H;
            int goodiesTemp = 0;
            for (int i = 0; i < T; i++) {
                int gInt = Integer.parseInt(goodies[i]);
                if (gInt <= mid) {
                    leftHours--;
                    goodiesTemp += gInt;
                } else {
                    leftHours -= gInt % mid;
                    goodiesTemp += gInt;
                }
            }
            if (leftHours > 0) {
                //we can reduce the speed
                rightEnd = mid - 1;
            } else if (goodiesTemp < totalGoodies) {
                //increase the speed
                leftEnd = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    String deCompressString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= 'z' && chars[i] >= 'a') {
                stringBuilder.append(chars[i]);
                //start finding the counts
                int startIndex = i + 1;
                StringBuilder n = new StringBuilder();
                while (startIndex < chars.length && chars[startIndex] >= 48 && chars[startIndex] <= 57) {
                    n.append(chars[startIndex]);
                    startIndex++;
                }
                if (n.length() > 0) {
                    int count = Integer.parseInt(n.toString());
                    for (int j = 0; j < count - 1; j++) {
                        stringBuilder.append(chars[i]);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
