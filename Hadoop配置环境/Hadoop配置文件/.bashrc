export JAVA_HOME=/opt/jdk
export JRE_HOME=$JAVA_HOME/jre
export CLASSPATH=.:$JAVA_HOME/lib
echo "config java env......"
export HADOOP_HOME=/opt/hadoop
echo "config hadoop env......"
export ZK_HOME=/home/hduser/hadoop/zookeeper-3.4.10
echo "config zookeeper env......"
export PATH=$PATH:$JAVA_HOME/bin:$HADOOP_HOME/bin:$HADOOP_HOME/sbin:$ZK_HOME/bin
