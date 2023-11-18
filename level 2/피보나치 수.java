// 시간초과로 실패
class Solution {
    public static int solution(int n) {
        int answer = 0;

        answer=fibo(n)%1234567;

        return answer;
    }

    public static int fibo(int a)
    {
        if(a<=1)
            return a;
        else
            return fibo(a-2) + fibo(a-1);
    }

}

class Solution {
    public static int solution(int n) {
        int answer[] = new int[n+1];
        
        for(int i =0; i<=n; i++)
        {
            if(i==0) answer[i] = 0;
            else if(i==1) answer[i] = 1;
            else {
                int sum = answer[i-2] + answer[i-1];
                answer[i] = sum % 1234567;
            }
        }
        
        return answer[n];
    }

}
