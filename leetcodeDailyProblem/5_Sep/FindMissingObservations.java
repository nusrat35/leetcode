///2028. Find Missing Observations (5 September 2024)
public class FindMissingObservations{
    public static void main(String[] args) {
        int[] rolls = {1,5,6};
        int mean = 3, n = 4;
        int[] ans = missingRolls(rolls, mean, n) ;

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int len = rolls.length, rollSum = 0;
        for (int i : rolls) rollSum += i;
        //System.out.println(rollSum);

        int target = ( mean * (len + n)) - rollSum ;
        //System.out.println("Target " + target);
        if( target < n || target > (6 * n)) return new int[0];

        int[] ans = new int[n];

        for (int i = n; i > 0; i--) {
            int j = 6;
            while (j > 0) {
                if(target >= j && ((target-j) >= i -1 )){
                    ans[i-1] = j;
                    target -= j;
                    break;
                }
                j--;
            }
        }

        return ans;
    }
}