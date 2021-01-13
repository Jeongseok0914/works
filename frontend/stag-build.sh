# bin/sh
git pull;
rm -rf dist;
yarn build:stag;
cp -r stag.config.js dist/
pm2 stop 4c-dashboard;
rm -rf /home/peernine/4c-dashboard
mv dist /home/peernine/4c-dashboard
pm2 start 4v-dashboard;