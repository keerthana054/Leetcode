var ArrayWrapper = function(nums) {
    this.nums = nums;
};

ArrayWrapper.prototype.valueOf = function() {
    var res = 0;
    for (var i=0;i<this.nums.length;i++) res+=this.nums[i];
    return res;
}

ArrayWrapper.prototype.toString = function() {
    return "["+this.nums.join(',')+"]";
}