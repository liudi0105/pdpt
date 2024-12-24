#!/usr/bin/env bash

# cd ../../pdpt-web/pdpt-web

pnpm i || exit
pnpm build || exit
tar zcvf dist.tar.gz -C dist . || exit
scp dist.tar.gz pdpt:/www/wwwroot/manage.tar.gz || exit

ssh pdpt "rm -r /www/wwwroot/manage/*"
ssh pdpt "cd /www/wwwroot/; tar zxvf manage.tar.gz -C manage/"
ssh pdpt "chown -R www:www /www/wwwroot/manage/"