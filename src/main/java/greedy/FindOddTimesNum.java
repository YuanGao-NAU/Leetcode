package greedy;

//在一个数组中，有两个数组出现了奇数次，其他的数都出现了偶数次，找到这两个数

public class FindOddTimesNum {
    public static void find(int[] arr) {

        int eor = 0;
        for(int num : arr) {
            eor = eor ^ num;
        }

        int rightMostOne = eor & (~eor + 1);

        int onlyOne = 0;
        for(int cur : arr) {
            if((cur & rightMostOne) == 0) {
                onlyOne ^= cur;
            }
        }

        System.out.println(onlyOne + ", " + (eor^onlyOne));
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,3,4,4,4};

        FindOddTimesNum.find(arr);
    }
}
