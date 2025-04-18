var ROMAN = map[byte]int{
    'I': 1,
    'V': 5,
    'X': 10,
    'L': 50,
    'C': 100,
    'D': 500,
    'M': 1000,
}

func romanToInt(s string) int {
    ans := 0
    for i:=1;i<len(s);i++{
        x,y:=ROMAN[s[i-1]],ROMAN[s[i]]
        if x<y{
            ans-=x
        } else{
            ans+=x
        }
    }
    return ans + ROMAN[s[len(s)-1]]
}