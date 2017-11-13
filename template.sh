#!/bin/sh

cp Template.java $1.java
sed -i -- "s/Template/$1/g" $1*
