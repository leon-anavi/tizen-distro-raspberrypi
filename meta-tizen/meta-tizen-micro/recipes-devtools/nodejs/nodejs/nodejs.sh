#! /bin/sh

if [ ! -d "/opt/vc/bin" ]; then
echo "export NODE_PATH=/usr/lib/node_modules/" >>/etc/profile
fi

mkdir -p /opt/vc/bin
ln -sf  /usr/bin/raspistill /opt/vc/bin/
ln -sf  /usr/bin/raspivid /opt/vc/bin/
