#!/bin/bash

# Ceck if file are passed as parameters
if [ $# -gt 0 ]
then
    while [[ $# -ge 1 ]]
    do
        # Save the current file
        file=$1;
        # Shift one file
        shift 1;
        # Make sure it does not have the required css
        if ! grep -q 'prefers-color-scheme' "$file"; then
            # Replace black with currentColor and add required css
            sed -i '' 's/<\/svg/<style>@media (prefers-color-scheme: dark){svg{filter: invert(100)\;}}<\/style><\/svg/' "$file";
            #/^<svg/s/black/currentColor/g;
        fi
    done
else
    # One liner that finds all svg files in the current directory
    # Checks if the file already have the correct css applied
    # Otherwise change the stroke from black to currentColor and add the correct css
    find . -name '*.svg' | xargs grep -riL 'prefers-color-scheme' | xargs sed -i '' 's/<\/svg/<style>@media (prefers-color-scheme: dark){svg{filter: invert(100)\;}}<\/style><\/svg/' 2>/dev/null;
fi