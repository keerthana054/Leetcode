var inorderTraversal = function*(arr) {
    for(let i of arr.flat(Infinity)) yield i;
};