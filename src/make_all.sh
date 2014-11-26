#!/bin/bash

cd `dirname $0`

jar_file_name='../rz-bi-project.jar'

rm $jar_file_name
export CLASSPATH=.:`hadoop classpath`
find . -name *.java | xargs javac
jar cvf $jar_file_name com

