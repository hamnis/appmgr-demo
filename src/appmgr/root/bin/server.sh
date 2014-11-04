#!/bin/bash

DIR=$(dirname $0)
DIR=$(cd $DIR/../ && pwd -P)

APP_HOME=${APP_HOME:-$DIR}

if [ "z$APP_FOREGROUND" = "z" ]; then
  mkdir -p "${APP_HOME}/logs"
  exec >> "${APP_HOME}/logs/demo.out"
  exec 2>&1
fi

#PORT=$(app conf get demo.PORT):=8000
PORT=${PORT:-8000}
cd $DIR/webapp
exec python -m SimpleHTTPServer $PORT 
