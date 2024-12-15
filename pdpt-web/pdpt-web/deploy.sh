#!/usr/bin/env bash

# cd ../../pdpt-web/pdpt-web

pnpm i || exit
pnpm build || exit
tar zcvf dist.tar.gz -C dist . || exit
scp dist.tar.gz pdpt:/www/wwwroot/ || exit

ssh pdpt "rm -r /www/wwwroot/test.hdpt.me/*"
ssh pdpt "cd /www/wwwroot/; tar zxvf dist.tar.gz -C test.hdpt.me/"
ssh pdpt "chown -R www:www /www/wwwroot/test.hdpt.me/"