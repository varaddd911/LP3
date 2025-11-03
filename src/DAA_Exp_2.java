import java.util.Arrays;

public class DAA_Exp_2 {
    char id;
    int deadline;
    int profit;

    public DAA_Exp_2(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    public static void main(String[] args) {
        DAA_Exp_2 arr[] = {new DAA_Exp_2('a', 2, 100),
                new DAA_Exp_2('b', 1, 19),
                new DAA_Exp_2('c', 2, 27),
                new DAA_Exp_2('d', 1, 25),
                new DAA_Exp_2('e', 3, 15)};
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for (DAA_Exp_2 e : arr) {
            if (e.deadline > maxDeadline) {
                maxDeadline = e.deadline;
            }
        }
        char[] schedule = new char[maxDeadline];
        Arrays.fill(schedule, '-');
        int totalprofit = 0;

        for (DAA_Exp_2 e : arr) {
            for (int slot = e.deadline - 1; slot >= 0; slot--) {
                if (schedule[slot] == '-') {
                    schedule[slot] = e.id;
                    totalprofit += e.profit;
                    break;
                }
            }
        }
        System.out.print("Jobs scheduled: ");
        for (char job : schedule) {
            if (job != '-') {
                System.out.print(job + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalprofit);
    }


}
