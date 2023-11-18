public static String solution(String s) {
    String answer = "";
    int j=0;
    ArrayList<Integer> sort = new ArrayList<>();
    for(int i =0; i <s.length(); i++)
    {
        if((int)s.charAt(i) != 32)
        {
            answer += s.charAt(i);
        }
        else
        {
            sort.add(Integer.valueOf(answer));
            answer = "";
            j++;
        }
    }

    sort.add(Integer.valueOf(answer));

    Collections.sort(sort);

    answer = sort.get(0) + " " + sort.get(sort.size()-1);
    System.out.println(answer);
    return answer;
}
// 참고해서 수정한 코드
class Solution {
    public static String solution(String s) {
        String[] tmp = s.split(" ");
        int min, max, n;
        min = max = Integer.parseInt(tmp[0]);

        for(int i =1; i<tmp.length; i++)
        {
            n = Integer.parseInt(tmp[i]);
            if(min > n) min = n;
            if(max < n) max = n;
        }

        return min + " " + max;
    }
}
