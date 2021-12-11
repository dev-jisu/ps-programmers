package BiggestNumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) {

        int[] numbers = {1,10,100,1000};
        Solution sol = new Solution();
        System.out.println(sol.solution(numbers));
    }
}

class Solution {

    class NumComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2));
        }

    }
    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }
        list.sort( new NumComparator());
        if (list.get(0).equals("0")) {
            return "0";
        }
        answer = list.stream().map(String::valueOf).collect(Collectors.joining());
        return answer;
    }
}