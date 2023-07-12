#include <stdio.h>

void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n);
void quickSort(int* arr, int len);

int main() {
    int nums1[] = {1,2,3,0,0,0,1};
    int num1Size = 7;
    int m = 3;
    int nums2[] = {2,5,6};
    int nums2Size = 3;
    int n = 3;
    merge(nums1, num1Size, m, nums2, nums2Size, n);

    return 0; 
}
 // // 合并数组
    // int i = 0;
    // int j = 0;
    // int k = 0;
    // while (i < m && j < n) {
    //     if (nums1[i] <= nums2[j]) {
    //         mergedArray[k++] = nums1[i++];
    //     } else {
    //         mergedArray[k++] = nums2[j++];
    //     }
    // }
    // merge the 2 arrays into mergedArray
void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
    for (int i = 0; i < n; i++) {
        nums1[m + i] = nums2[i];
    }
    quickSort(nums1, nums1Size);
}

void quickSort(int* arr, int len){
    if (len <= 1) {
        return;
    }
    int pivot = arr[0];
    int i = 0;
    int j = len - 1;
    while (i < j) {
        while (i < j && arr[j] >= pivot) {
            j--;
        }
        arr[i] = arr[j];
        while (i < j && arr[i] <= pivot) {
            i++;
        }
        arr[j] = arr[i];
    }
    arr[i] = pivot;
    quickSort(arr, i);
    quickSort(arr + i + 1, len - i - 1);
}

void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
    // Initialize i and j to store indices of the last element of 1st and 2nd array respectively...
    int i = m - 1;
    int j = n -1;
    // Create a loop until either of i or j becomes zero...
    while(i>=0 && j>=0) {
        if(nums1[i] > nums2[j]) {
            nums1[i+j+1] = nums1[i];
            i--;
        } else {
            nums1[i+j+1] = nums2[j];
            j--;
        }
    }
    // While j does not become zero...
    while(j >= 0) {
        nums1[i+j+1] = nums2[j];
        j--;
    }
}