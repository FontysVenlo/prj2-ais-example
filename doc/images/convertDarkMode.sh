#! /bin/bash

find . -name '*.svg' -exec sed -i '/^<svg/s/black/currentColor/g;s/<\/svg/<style> \*{color:#000\;}@media (prefers-color-scheme: dark){\*{color: #fff\;}}<\/style><\/svg/' {} \;
