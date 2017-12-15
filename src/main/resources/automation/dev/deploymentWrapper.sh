#!/bin/bash
stackName=$1
echo "Dependencies will not be installed with this script. Run InstallDependencies.sh if host machine is missing programs."
./CreateStack.sh $stackName
echo "Invoking Cloud Formation Script......"