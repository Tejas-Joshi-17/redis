
source "$SDKMAN_DIR/bin/sdkman-init.sh"
sdk use java 17.0.12-oracle
sdk use gradle 8.10.2

BUILD_FOLDER="build/install/redis/bin"

if [[ -d $BUILD_FOLDER ]]
then
    cd $BUILD_FOLDER || exit
    bash stop
    cd ../../../../ || exit
    gradle clean
    echo "Project Cleaned Successfully"
else
    gradle clean iA
    echo "Project Cleaned Successfully"
fi