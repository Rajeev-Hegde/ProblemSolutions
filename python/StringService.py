

def print_unique_chars_in_sub_string(str,k):
    for item in str:
        len_temp += 1
        if item not in temp:
            temp.append(item)
        if len_temp == k:
            print(''.join(temp))
            temp = []
            len_temp = 0
