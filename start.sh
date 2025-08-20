# JUnit = Java Unit

rm -rf ./logs/*.*

# Kill any running jmeter-testing process
PID=$(ps -ef | grep "redis-learning" | grep -v grep | awk '{print $2}')
if [[ -n $PID ]]; then
  kill -9 "$PID"
  echo "Already Running Process Stopped ..."
else
  echo "Ready to Build Project"
fi

source "$SDKMAN_DIR/bin/sdkman-init.sh"
sdk use java 17.0.12-oracle
sdk use gradle 8.10.2

gradle clean build

java -jar -Dspring.application.name="redis-learning" ./build/libs/redis-1.0.1.jar