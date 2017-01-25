#!/bin/sh

echo "************ UNDEPLOYING *******************"
asadmin undeploy restfullservice
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
asadmin deploy target/restfullservice.war
