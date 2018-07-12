INSERT INTO Account (ID, firstName, lastName, accountNumber) VALUES (1, 'Benny', 'Wong', '000001');
INSERT INTO Account (ID, firstName, lastName, accountNumber) VALUES (2, 'Andy', 'Test', '000002');
INSERT INTO Account (ID, firstName, lastName, accountNumber) VALUES (3, 'John','Doe','000003');

INSERT INTO Transactions (TRANSACTION_ID, transactionName, ACCOUNT_ID) VALUES (1,'Transfer 1', 2);
INSERT INTO Transactions (TRANSACTION_ID, transactionName, ACCOUNT_ID) VALUES (2,'Transfer 2', 3);
INSERT INTO Transactions (TRANSACTION_ID, transactionName, ACCOUNT_ID) VALUES (3,'Transfer 3', 3);
