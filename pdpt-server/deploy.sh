#!/usr/bin/env bash

cd ../ || ext
./gradlew build -x test || exit
scp build/libs/pdpt-1.0.jar pdpt:~/compose/pdpt-app/ || exit
ssh pdpt "cd /root/compose/pdpt-app; docker compose down; docker compose up -d"