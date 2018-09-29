To run :

start server as below:

main class: CashFlowApplication.java

arguments: server src/resources/assingment/test.yml

java -jar cashflow.jar server src/resources/assingment/test.yml



Test Case:

URI: POST 

http://localhost:8080/cash-flow/

http://localhost:8080/cash-flow/simplified

http://localhost:8080/cash-flow/basic


BODY: 
{
	"totalAmount":1100,
	"liability": {"A": 300,"B": 700,"C": 0,"D":100},
	"payment": {"A": 500,"B": 25,"C": 525,"D":50}
}
