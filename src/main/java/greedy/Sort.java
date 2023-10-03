package greedy;

public class Sort {

    public static void bubbleSort(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = 1; j < nums.length; j++) {
                if(nums[i] > nums[j]) {
                    int temp= nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] nums, int start, int end) {
        if(start >= end) return;

        int i = start;
        int j = end;
        int pivot = nums[start];

        while(i < j) {
            while(i < j && nums[j] >= pivot) {
                j--;
            }
            while(i < j && nums[i] <= pivot) {
                i++;
            }

            if(i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        nums[start] = nums[i];
        nums[i] = pivot;

        quickSort(nums, start, i-1);
        quickSort(nums, i+1, end);
    }

    public static void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right) >> 1;
        mergeSortCore(nums, left, mid, right, temp);
    }

    public static void mergeSortCore(int[] nums, int left, int mid, int right, int[] temp) {
        if(left == mid && mid == right) return;
        mergeSortCore(nums, left, (left+mid)>>1, mid, temp);
        mergeSortCore(nums, mid+1, (mid+1+right)>>1, right, temp);

        int p1 = left;
        int p2 = mid+1;
        int p3 = left;

        while(p1 <= mid && p2 <= right) {
            if(nums[p1] < nums[p2]) {
                temp[p3++] = nums[p1++];
            } else {
                temp[p3++] = nums[p2++];
            }
        }

        if(p1 <= mid) {
            temp[p3++] = nums[p1++];
        } else if(p2 <= right) {
            temp[p3++] = nums[p2++];
        }

        for(int i = left; i <= right; i++) {
            nums[i] = temp[i];
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,4,7,6,4,5,1,100,99};
//        Sort.quickSort(nums, 0, nums.length-1);
        Sort.mergeSort(nums);
        for(int num : nums) {
            System.out.println(num);
        }
    }
}
