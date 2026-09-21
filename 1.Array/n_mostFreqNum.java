import java.util.HashMap;

    public static int findMostFrequent(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int mostFrequent = arr[0];
        int maxFrequency = 0;

        for (int num : arr) {

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }

            if (map.get(num) > maxFrequency) {
                maxFrequency = map.get(num);
                mostFrequent = num;
            }
        }

        return mostFrequent;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 1, 2};

        int answer = findMostFrequent(arr);

        System.out.println("Most frequent element: " + answer);
    }
