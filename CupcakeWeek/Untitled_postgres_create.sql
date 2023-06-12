CREATE TABLE "public.Customer" (
	"customerId" serial NOT NULL,
	"firstName" VARCHAR(255) NOT NULL,
	"lastName" VARCHAR(255) NOT NULL,
	"email" TEXT NOT NULL,
	"phoneNumber" integer(9) NOT NULL,
	CONSTRAINT "Customer_pk" PRIMARY KEY ("customerId")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.Production" (
	"productId" serial NOT NULL,
	"brand" TEXT NOT NULL,
	"model" TEXT NOT NULL,
	"description" TEXT NOT NULL,
	"price" DECIMAL NOT NULL,
	"quantity" integer NOT NULL,
	CONSTRAINT "Production_pk" PRIMARY KEY ("productId")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.Transactions" (
	"transactionId" serial NOT NULL,
	"customerId" integer NOT NULL,
	"productId" integer NOT NULL,
	"transactionDate" DATE NOT NULL,
	CONSTRAINT "Transactions_pk" PRIMARY KEY ("transactionId")
) WITH (
  OIDS=FALSE
);





ALTER TABLE "Transactions" ADD CONSTRAINT "Transactions_fk0" FOREIGN KEY ("customerId") REFERENCES "Customer"("customerId");
ALTER TABLE "Transactions" ADD CONSTRAINT "Transactions_fk1" FOREIGN KEY ("productId") REFERENCES "Production"("productId");




