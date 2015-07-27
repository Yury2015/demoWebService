# demoWebService 

Проект для Glassfish
IDE NetBeans

WebService JAX-WS с использованием очереди.

Предварительно, перед тем как деплоить web service на Glassfish,
надо создать очереди с использованием asadmin:

asadmin create-jms-resource --restype javax.jms.ConnectionFactory jms/javaee7/ConnectionFactory
asadmin create-jms-resource --restype javax.jms.Topic jms/javaee7/Queue
