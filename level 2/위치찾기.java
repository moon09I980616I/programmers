import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("총 두 개의 숫자를 입력해야한다. 두 개의 숫자에는 0~4까지만 들어갈 수 있다. ex) 44(O), 17(X)");

        Scanner scanner = new Scanner(System.in);

        int size = 5;
        int cnt = 10;
        int res = 0;
        int success = 5;

        char board[][] = new char[size][size];
        byte shipboard[][] =boardSetting(size);

        int x = 0, y=0;

        while(true){
            System.out.printf("입력하세요. 남은 입력 횟수 : %d (종료 : 00) \n",cnt);
            String input = scanner.nextLine();

            if(Objects.equals(input, "y"))
                boardSetting(size);
            else if(Objects.equals(input, "n"))
                   break;

            if(input.length() == 2)
            {
                x = input.charAt(0) - '0';
                y = input.charAt(1) - '0';

                if(x > 4 || y > 4)
                {
                    System.out.println("숫자가 너무 큽니다. 다시 입력하세요.");
                    continue;
                }

                cnt--;

                board[x][y] = shipboard[x][y] == 1 ? 'O':'X';

                if(board[x][y] == 'O')
                    res++;

                for(int i=0; i<size; i++)
                    System.out.println(board[i]);
                System.out.println();

                if(res==success)
                    System.out.println("성공! 다시 진행하겠습니까 ? (y/n)");

                if(x==0 && y==0)
                {
                    System.out.println("종료하였습니다.");
                    break;
                }

                if(cnt==0)
                {
                    System.out.println("실패");
                    break;
                }

            }
        }
    }

    public static byte[][] boardSetting(int size)
    {
        Random random = new Random();

        byte shipboard[][] = new byte[size][size];
        for (byte[] val : shipboard) {
            for (int i = 0; i < val.length; i++) {
                val[i] = (byte) random.nextInt(2);
            }
        }

        return shipboard;
    }
}
