# ===========================================
# ****** MQ_File_Transfer_Script ******
# Description:Putting the File onto MQ
# Author:Laksham Thandra
# Verison:1.0 
# Date:07/16/2020
# ===========================================
# Creating a Queue Manager
mqm@ubuntu:/opt/mqm/bin$ ./crtmqm QM1
IBM MQ queue manager created.
Directory '/var/mqm/qmgrs/QM1' created.
The queue manager is associated with installation 'Installation1'.
Creating or replacing default objects for queue manager 'QM1'.
Default objects statistics : 83 created. 0 replaced. 0 failed.
Completing setup.
Setup completed.
# Starting a Queue Manager
mqm@ubuntu:/opt/mqm/bin$ ./strmqm QM1
The system resource RLIMIT_NOFILE is set at an unusually low level for IBM MQ.
IBM MQ queue manager 'QM1' starting.
The queue manager is associated with installation 'Installation1'.
5 log records accessed on queue manager 'QM1' during the log replay phase.
Log replay for queue manager 'QM1' complete.
Transaction manager state recovered for queue manager 'QM1'.
IBM MQ queue manager 'QM1' started using V9.0.0.0.
# Run Queue Manager
mqm@ubuntu:/opt/mqm/bin$ ./runmqsc QM1
5724-H72 (C) Copyright IBM Corp. 1994, 2016.
Starting MQSC for queue manager QM1.
# Defining a Queue
define Qlocal(Queue)
     1 : define Qlocal(Queue)
AMQ8006: IBM MQ queue created.

# =======Starting Shell Script===========
#! /bin/bash
# Move to file content directory
cd /home/mqm/
# Storing the file into a variable
var=`cat File.xml`        
# Printing the data into the variable
echo $var 
# Move to amqsput command location directory
cd /opt/mqm/samp/bin/
# Store the variable onto MQ
echo ${var}|/opt/mqm/samp/bin/amqsput Queue QM1 
#=========================================

