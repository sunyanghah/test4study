#!/bin/sh

# 设置 jar 名称
JAR_NAME="study-license"


#
# 只需要考虑修改以上参数就行
#


# 设置项目的根路径
export BASE_DIR=`cd $(dirname $0)/..; pwd`

PID=`ps -ef | grep -i "${JAR_NAME}.jar" | grep java | grep -v grep | awk '{print $2}'`

if [ -z "$PID" ] ; then
        echo "No ${JAR_NAME} running."
        exit 1;
fi

echo "The ${JAR_NAME} is running ,PID is (${PID}) ..."

kill ${PID}

if [ $? != 0 ]; then
    echo "kill ${JAR_NAME} fail"
    exit 1;
fi
#echo "kill ${JAR_NAME} is OK, PID (${PID} shutdown )"
