#! /bin/bash
echo 'setting start...'

apt update &&
apt install -y openjdk-8-jdk-headless &&

echo 'stating service...'
java -jar -Dspring.profiles.active=dev /data/*.jar