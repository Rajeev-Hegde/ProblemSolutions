#!/usr/bin/env bash
lineRange=$(head -n 1 input)
to=$(($(echo $lineRange | awk  '{print $2}')+1))
from=$(($(echo $lineRange | cut -d" " -f1)))
sed -n "$from,$to p" input