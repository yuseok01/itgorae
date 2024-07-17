import java.util.*;

public class Programmers_6_주차요금계산 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600}; // 기본시간, 기본요금, 단위시간, 단위요금
        String[] record = {
            "05:34 5961 IN", "06:00 0000 IN",
            "06:34 0000 OUT", "07:59 5961 OUT",
            "07:59 0148 IN", "18:59 0000 IN",
            "19:09 0148 OUT", "22:59 5961 IN",
            "23:00 5961 OUT"
        };
        int[] result = solution(fees, record);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<Integer, List<Integer>> carTimes = new HashMap<>();
        Set<Integer> carNumbers = new HashSet<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String[] timeSplit = split[0].split(":");
            int minutes = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
            int carNumber = Integer.parseInt(split[1]);
            String action = split[2];

            carNumbers.add(carNumber);

            if (!carTimes.containsKey(carNumber)) {
                carTimes.put(carNumber, new ArrayList<>());
            }
            carTimes.get(carNumber).add(minutes);
        }

        Map<Integer, Integer> carFees = new HashMap<>();

        for (int carNumber : carNumbers) {
            List<Integer> times = carTimes.get(carNumber);
            if (times.size() % 2 != 0) {
                times.add(23 * 60 + 59); // 출차 기록이 없으면 23:59에 출차한 것으로 간주
            }
            int totalMinutes = 0;
            for (int i = 0; i < times.size(); i += 2) {
                totalMinutes += times.get(i + 1) - times.get(i);
            }

            int totalFee = basicFee;
            if (totalMinutes > basicTime) {
                totalFee += Math.ceil((totalMinutes - basicTime) / (double) unitTime) * unitFee;
            }

            carFees.put(carNumber, totalFee);
        }

        List<Integer> sortedCarNumbers = new ArrayList<>(carNumbers);
        Collections.sort(sortedCarNumbers);
        int[] answer = new int[sortedCarNumbers.size()];
        for (int i = 0; i < sortedCarNumbers.size(); i++) {
            answer[i] = carFees.get(sortedCarNumbers.get(i));
        }

        return answer;
    }
}
