public class Programmers_9_택배배달과수거하기 {

    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        long result = solution(cap, n, deliveries, pickups);
        System.out.println(result);  // 기대 결과: 16
    }

    private static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long totalDistance = 0;
        int deliveryLocation = n - 1;
        int pickupLocation = n - 1;

        while (deliveryLocation >= 0 || pickupLocation >= 0) {
            // 현재 트럭의 적재 상태 초기화
            int truckDelivery = 0;
            int truckPickup = 0;

            // 가장 먼 지점부터 배달할 물품이 있는 곳 탐색
            while (deliveryLocation >= 0 && deliveries[deliveryLocation] == 0) {
                deliveryLocation--;
            }

            // 가장 먼 지점부터 수거할 물품이 있는 곳 탐색
            while (pickupLocation >= 0 && pickups[pickupLocation] == 0) {
                pickupLocation--;
            }

            // 현재 탐색된 가장 먼 지점 계산
            int currentMaxIndex = Math.max(deliveryLocation, pickupLocation);

            if (currentMaxIndex < 0) {
                break;
            }

            // 해당 지점까지 왕복 거리 계산
            totalDistance += (currentMaxIndex + 1) * 2;

            // 배달 처리
            for (int i = currentMaxIndex; i >= 0; i--) {
                if (truckDelivery + deliveries[i] <= cap) {
                    truckDelivery += deliveries[i];
                    deliveries[i] = 0;
                } else {
                    deliveries[i] -= (cap - truckDelivery);
                    truckDelivery = cap;
                    break;
                }
            }

            // 수거 처리
            for (int i = currentMaxIndex; i >= 0; i--) {
                if (truckPickup + pickups[i] <= cap) {
                    truckPickup += pickups[i];
                    pickups[i] = 0;
                } else {
                    pickups[i] -= (cap - truckPickup);
                    truckPickup = cap;
                    break;
                }
            }
        }

        return totalDistance;
    }
}
