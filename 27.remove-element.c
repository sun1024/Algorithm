int removeElement(int* nums, int numsSize, int val) {
    int i,j;
    i = 0;
    j = 0;
    for(i ; i < numsSize; i++)
    {
        if(nums[i] == val)
        {
            continue;
        }
        nums[j] = nums[i];
        j++;
    }
    return j;
}