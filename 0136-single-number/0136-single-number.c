#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int key;
    int value;
    int isOccupied;
} HashMapEntry;

typedef struct {
    HashMapEntry* entries;
    int size;
    int capacity;
} HashMap;

HashMap* createHashMap(int capacity) {
    HashMap* hashMap = (HashMap*)malloc(sizeof(HashMap));
    hashMap->entries = (HashMapEntry*)calloc(capacity, sizeof(HashMapEntry));
    hashMap->size = 0;
    hashMap->capacity = capacity;
    return hashMap;
}

int hash(int key, int capacity) {
    return abs(key) % capacity;
}

void insert(HashMap* hashMap, int key, int value) {
    int idx = hash(key, hashMap->capacity);
    while (hashMap->entries[idx].isOccupied && hashMap->entries[idx].key != key) {
        idx = (idx + 1) % hashMap->capacity;
    }
    if (hashMap->entries[idx].isOccupied && hashMap->entries[idx].key == key) {
        hashMap->entries[idx].value = value;
    } else {
        hashMap->entries[idx].key = key;
        hashMap->entries[idx].value = value;
        hashMap->entries[idx].isOccupied = 1;
        hashMap->size++;
    }
}

int find(HashMap* hashMap, int key) {
    int idx = hash(key, hashMap->capacity);
    int startIdx = idx;
    while (hashMap->entries[idx].isOccupied) {
        if (hashMap->entries[idx].key == key) {
            return hashMap->entries[idx].value;
        }
        idx = (idx + 1) % hashMap->capacity;
        if (idx == startIdx) {
            break;
        }
    }
    return -1;
}

void freeHashMap(HashMap* hashMap) {
    free(hashMap->entries);
    free(hashMap);
}

int singleNumber(int* nums, int numsSize) {
    HashMap* hashMap = createHashMap(numsSize);
    
    for (int i = 0; i < numsSize; i++) {
        int count = find(hashMap, nums[i]);
        if (count == -1) {
            insert(hashMap, nums[i], 1);
        } else {
            insert(hashMap, nums[i], count + 1);
        }
    }

    for (int i = 0; i < numsSize; i++) {
        int count = find(hashMap, nums[i]);
        if (count == 1) {
            freeHashMap(hashMap);
            return nums[i];
        }
    }

    freeHashMap(hashMap);
    return -1;
}



