# demoWebService 

������ ��� Glassfish
IDE NetBeans

WebService JAX-WS � �������������� �������.

��������������, ����� ��� ��� �������� web service �� Glassfish,
���� ������� ������� � �������������� asadmin:

asadmin create-jms-resource --restype javax.jms.ConnectionFactory jms/javaee7/ConnectionFactory
asadmin create-jms-resource --restype javax.jms.Topic jms/javaee7/Queue
