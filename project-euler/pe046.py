"""
Goldbach's other conjecture
Problem 46
It was proposed by Christian Goldbach that every odd composite number can be
written as the sum of a prime and twice a square.

9 = 7 + 2×1^2
15 = 7 + 2×2^2
21 = 3 + 2×3^2
25 = 7 + 2×3^2
27 = 19 + 2×2^2
33 = 31 + 2×1^2

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime
and twice a square?
"""
__date__ = '14-3-27'
__author__ = 'SUN'

def is_prime(n):
    if n == 0 or n == 1:
        return False
    if n % 2 == 0 or n % 3 == 0 or n % 5 == 0:
        return n == 2 or n == 3 or n == 5
    for i in range(7, int(n ** 0.5) + 1, 2):
        if n % i == 0:
            return False
    return True

def is_go_other_con(n):
    for i in range(int((n / 2) ** 0.5) + 1):
        if is_prime(n - 2 * i * i):
            return True
    return False

if __name__ == '__main__':
    k = 9
    while is_go_other_con(k):
        k += 2
    print(k)