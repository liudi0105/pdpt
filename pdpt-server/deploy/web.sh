#!/usr/bin/env bash

cd ../../pdpt-web/pdpt-web

pnpm i || exit
pnpm build || exit
tar zcvf dist.tar.gz dist/ || exit
scp dist.tar.gz pdpt:~/compose/pdpt-app/ || exit