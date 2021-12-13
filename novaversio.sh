#!/bin/bash

env mvn -DgroupId=es.caib.scsp -DartifactId=* versions:set -DnewVersion=$@  

