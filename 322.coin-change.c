/*
** author:adminsun
*/

#include <malloc.h>

int coinChange(int* coins, int coinsSize, int amount) {
    int *bp = (int *) malloc(sizeof(int) * (amount + 1));
    bp[0] = 0;
    for (int i = 1; i <= amount; i++) {
        bp[i] = i;
    }
    for (int i = 1; i < amount + 1; i++) {
        for (int j = 0; j < coinsSize; j++) {
            if (i >= coins[j]) {
                bp[i] = bp[i] > (bp[i - coins[j]] + 1) ? (bp[i - coins[j]] + 1) : bp[i];
            }
        }
    }
    if (bp[amount] == amount) {
        return -1;
    }
    return bp[amount];
}