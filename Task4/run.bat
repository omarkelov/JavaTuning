cd Agent
call gradle jar
cd ../TransactionProcessor
call gradle jar
cd ..
java -javaagent:Agent/build/libs/agent.jar -jar TransactionProcessor/build/libs/transaction-processor.jar
pause
