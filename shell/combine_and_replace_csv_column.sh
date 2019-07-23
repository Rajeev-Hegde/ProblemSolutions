#!/usr/bin/env bash

while IFS=',' read -r f1 f2 f3 f4 f5 f6 f7
do
    echo "$f1,$f2,$f3,$f4,$f6,+$f5-$f7"
done < input




#solution 2
awk -F, '{$7="+"$5"-"$7;NF=7}1' OFS=, input | awk -F, '{$5=""}1' OFS=, | sed  -e 's/,,/,/g'
