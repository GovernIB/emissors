#!/bin/bash

echo off
cat help.txt

env mvn -DskipTests $@ install 
