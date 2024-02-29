#!/usr/bin/env bash

dirs=($(ls -d */))

# cd api-admin
# git config user.name "Philip Borbon" && git config user.email "philip.borbon@nextbasket.com"
# cd ..

for dir in "${dirs[@]}"
do
   dir="${dir/%\/}"
   
   echo ">> $dir"
   cd $dir
   git config user.name "Philip Borbon" && git config user.email "philip.borbon@nextbasket.com"
   cd ..
done