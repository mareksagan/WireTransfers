# WireTransfers
Banking transaction system using Hyperledger Fabric blockchain and Drools BPM

## Requirements
* API will expose an endpoint which accepts the user information (**customerID**, **initialCredit**)
* Once the endpoint is called, a new account will be opened connected to the user whose ID is
**customerID**
* If **initialCredit** is not 0, a transaction will be sent to the new account
* Another Endpoint will output the user information showing **Name**, **Surname**, **Balance** and
**Transactions** of the accounts

## Installation
* Set up [Maven](https://maven.apache.org/download.cgi) and [JDK 11](https://adoptopenjdk.net/) on your machine
* Run `mvn clean install`
* Run `mvn package` to deploy a JAR file
