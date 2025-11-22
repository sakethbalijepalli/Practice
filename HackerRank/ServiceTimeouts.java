package HackerRank;

import java.util.*;

public class ServiceTimeouts {

    public static void main(String[] args) {

        List<Integer> t1 = new ArrayList<>(Arrays.asList(10, 20, 80, 10, 65));
        List<String> s1 = new ArrayList<>(Arrays.asList("svc1", "svc1", "svc1", "svc2", "svc2"));
        int threshold1 = 30;
        System.out.println(detectServiceTimeouts(t1, s1, threshold1));

        List<Integer> t2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<String> s2 = new ArrayList<>(Arrays.asList("svc1", "svc2", "svc1"));
        int threshold2 = 1;
        System.out.println(detectServiceTimeouts(t2, s2, threshold2));

    }

    public static List<String> detectServiceTimeouts(List<Integer> timestamp, List<String> serviceId, int threshold) {
        Map<String, List<Integer>> serviceMap = new HashMap<>();
        for (int i = 0; i < serviceId.size(); i++) {
            serviceMap.computeIfAbsent(serviceId.get(i), k -> new ArrayList<>()).add(timestamp.get(i));
        }

        List<String> timedOutServices = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : serviceMap.entrySet()) {
            List<Integer> times = entry.getValue();
            if (times.size() < 2) continue;
            Collections.sort(times);

            boolean timedOut = false;
            for (int i = 1; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 1) > threshold) {
                    timedOut = true;
                    break;
                }
            }

            if (timedOut) timedOutServices.add(entry.getKey());
        }
        Collections.sort(timedOutServices);
        return timedOutServices;
    }

}
