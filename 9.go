func isPalindrome(x int) bool {
    if x <0 || (x%10==0&&x!=0){
        return false
    }
    r:=0
    for x > r{
        tmp := x%10
        r = r*10+tmp
        x = x/10
    }
    return x==r||x==r/10
}