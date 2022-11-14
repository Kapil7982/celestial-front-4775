# Online Payment Wallet Application REST-API
Our team has created REST API Application for online payment wallet application which can be used by bank's customers for different services like create bank account, login and SignUp to account, create wallet from bank account, add money to wallet, Billpayment from wallet, get transaction details from wallet etc.

## This is a collaborative project, completed by a team of 5 backend developers.

## Collaborators
 - [Kapil](https://github.com/Kapil7982)
 - [Amar Sarkar](https://github.com/amarsarkar007) 
 - [Ashirvad kumar](https://github.com/Ashirvad121)
- [Rajat Santra](https://github.com/ChocotacoOp)
- [Himanshu Rajput](https://github.com/RajputHim)

## REST API Use for below functions
- Create Bank account and wallet.
- User can Login and Signup.
- Delete Bank account.
- Adding money to wallet.
- Money Transfer from one wallet to another wallet.
- Any Bill payments from wallet.
- User can see transactions details from wallet.
- CashBack Section.

## Tech Stack
- Java
- Hibernate
- Spring Framework
- Spring Boot with JPA
- MySQL
- Maven
- Swagger UI

Our contribution to Project-
* Kapil-> Wallet Module 
* Amar Sarkar-> Customer, Bank Module
* Ashirvad kumar-> Beneficiary
* Rajat Santra-> BillPayment
* Himanshu Rajput -> Transaction

## Modals
- Authentication 
- Bank Account
- Customer
- Wallet
- Bill Payment
- Cashback
- Transactions
- Beneficiary



## MySql database details

Install and connect with database

```bash
#db specific properties
spring.datasource.url=jdbc:mysql://localhost:8888/upay
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=port
```

## API Functionality are-
- #### User features
1.  User can login and SignUp.
2.  User can logout.

- #### Bank Account features
1.  User can create the bank account.
2.  User can get the account details.
3.  User can delete the account details.

- #### Customer features
1.  Customer can save the details with bank.
2.  Customer can update the details with bank.

- #### Wallet features

1.  User can create account in the wallet.
2.  User can add the money to the wallet.
3.  User can transfer the money from wallet.
4.  User can seen the wallet balance.
5.  User can deposit amount in the wallet.
6.  User can seen the list of customer.

- #### Beneficiary features
1.  User can add the new benificiary.
2.  User can delete the benificiary.
3.  User can view the particular benificiary.
4.  User can view all the benificiary


- #### Bill payment features
1.  User can pay any bill from wallet.
2.  User can get all bills details.

- #### Transaction features
1.  User can seen the transaction details with date wise.
2.  User can see the transaction details with wallet user.
3. User can see all the transaction details.

## ER Diagram
![image](https://user-images.githubusercontent.com/103938868/201588137-5c603047-820c-4038-83bc-eece7e7cda42.png)




