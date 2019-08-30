#!/bin/python3

import os
import random
import re
import sys
from collections import Counter
import itertools


if __name__ == '__main__':
    s = [char for char in input()]
    s.sort()
    my_dict= Counter(s).most_common(3)
    for val in my_dict:
        print(val[0], val[1])
