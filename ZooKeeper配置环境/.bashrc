# .bashrc

# Source global definitions
if [ -f /etc/bashrc ]; then
	. /etc/bashrc
fi

# Uncomment the following line if you don't like systemctl's auto-paging feature:
# export SYSTEMD_PAGER=

# User specific aliases and functions

export JAVA_HOME=/opt/jdk
export JRE_HOME=$JAVA_HOME/jre
export CLASSPATH=.:$JAVA_HOME/lib
#export PATH=$PATH:$JAVA_HOME/bin
echo "config java env......"
export HADOOP_HOME=/opt/hadoop
#export PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin
echo "config hadoop env......"
export ZK_HOME=/home/hduser/hadoop/zookeeper-3.4.10
echo "config zookeeper env......"
export PATH=$PATH:$JAVA_HOME/bin:$HADOOP_HOME/bin:$HADOOP_HOME/sbin:$ZK_HOME/bin
