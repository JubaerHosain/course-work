from string import ascii_lowercase
from time import time_ns


def cmp(a, b):
    if len(a) != len(b):
        return False
    for i in range(len(a)):
        if a[i] != b[i]:
            return False
        else:
            return True


secrete = "secrete"
def login(password):
    if cmp(password, secrete):
        return "Login successful"
    else:
        return "Login failed"


def cracked_letter(cracked, padding):
    time_map = {key: 0 for key in ascii_lowercase}
    for _ in range(10000):
        for letter in ascii_lowercase:
            guessed = cracked + letter + "-" * padding
            start = time_ns()
            login(guessed)
            end = time_ns()
            time_map[letter] += (end - start)
    return sorted(time_map, key=time_map.get, reverse=True)[0]

padding_len = len(secrete)-1
matched = ""
for _ in range(padding_len):
    curr = cracked_letter(matched, padding_len)
    matched += curr
    padding_len -= 1
    print(matched)
    
    
    
    
