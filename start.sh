
BUILD_FOLDER="build/install/redis/bin"


if [[ -d $BUILD_FOLDER ]]
then
  cd $BUILD_FOLDER || exit
  bash stop
  cd ../../../../ || exit
  gradle clean iA
  source setenv.sh
  cd $BUILD_FOLDER || exit
  bash start
else
    gradle clean iA
    source setenv.sh
    cd $BUILD_FOLDER || exit
    bash start
fi