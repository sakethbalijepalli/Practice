package HackerRank;

import java.util.*;

public class IbmProblem1 {

    static void main(String[] args) {
        int k = 2, t = 10;
        List<Integer> timestamps = new ArrayList<>(Arrays.asList(100, 101, 102, 105, 110));
        List<String> errorCodes = new ArrayList<>(Arrays.asList("E1", "E2", "E1", "E1", "E2"));
        System.out.println(getErrorCodes(k, t, timestamps, errorCodes));
    }

    public static List<String> getErrorCodes(int k, int t, List<Integer> timestamps, List<String> errorCodes) {
        int n = timestamps.size();
        if (n == 0 || k <= 0) return Collections.emptyList();

        int lastTs = timestamps.get(n - 1);
        long windowStart = (long) lastTs - t + 1;
        int start = lowerBound(timestamps, windowStart);

        Map<String, Integer> freq = new HashMap<>();
        for (int i = start; i < n; i++) {
            String code = errorCodes.get(i);
            if (freq.containsKey(code)) {
                freq.put(code, freq.get(code) + 1);
            } else {
                freq.put(code, 1);
            }
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            if (e.getValue() >= k) ans.add(e.getKey());
        }
        Collections.sort(ans);
        return ans;
    }

    private static int lowerBound(List<Integer> a, long target) {
        int lo = 0, hi = a.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if ((long) a.get(mid) >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

}
