#!/bin/bash

touch err 
while true
do
	git pull 1>/dev/null 2>err 
	errMsg=`cat err`
	if [ ${#errMsg} -eq 0 ]
	then
		break
	else
		for iFile in `cat err | grep -oe "[a-zA-Z0-9\/\-]*\.[a-zA-Z]\{1,\}"`
		do
			rm -f $iFile
		done
	fi
done
rm err
