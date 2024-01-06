type FilterFn<T> = (element: T, index?: number, array?: T[]) => boolean;

function filter<T>(arr: T[], fn: FilterFn<T>): T[] {
    const filteredArr: T[] = [];
    for (let i = 0; i < arr.length; i++) {
        if (fn(arr[i], i, arr)) {
            filteredArr.push(arr[i]);
        }
    }
    return filteredArr;
}