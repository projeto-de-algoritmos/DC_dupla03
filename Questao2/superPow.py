class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        mod = 1337 
        def calc(a,n):
            if n == 0:
                return 1
            elif n < 0:
                return 1 / calc(a, -n) %mod
            
            half = calc(a,n//2)
            
            if n % 2 == 0:
                return (half %mod * half %mod ) %mod
            else:
                return (half %mod * half %mod * a %mod) %mod
            
            
            
        val = ''.join(map(str, b))
        return calc(a,int(val)) % mod