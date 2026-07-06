# InsuranceHub

# Domain Model

| **Document Information** |                          |
| ------------------------ | ------------------------ |
| **Document ID**          | INS-DOM-001              |
| **Project Name**         | InsuranceHub             |
| **Document Name**        | Domain Model             |
| **Version**              | 1.0                      |
| **Status**               | Draft                    |
| **Author**               | Subhojeet Ghosh          |
| **Reviewer**             | Ace (Solution Architect) |
| **Date**                 | 04-Jul-2026              |

---

# 1. Purpose

The Domain Model defines the core business entities, their responsibilities, relationships, ownership, and business rules within the InsuranceHub Health Insurance Management System.

It serves as the foundation for:

* Database Design
* API Design
* Microservice Design
* User Interface Design
* Business Logic
* Testing

---

# 2. Domain Overview

InsuranceHub provides a platform where customers can:

* Register
* Complete KYC
* Apply for health insurance
* Purchase insurance policies
* Pay premiums
* Submit insurance claims
* Track policy and claim status

The system is divided into several business domains, each owned by a dedicated microservice.

---

# 3. Domain Boundaries

| Domain        | Primary Responsibility         | Future Microservice  |
| ------------- | ------------------------------ | -------------------- |
| Identity      | Authentication & Authorization | Identity Service     |
| Customer      | Customer Profile & KYC         | Customer Service     |
| Policy        | Plans, Applications & Policies | Policy Service       |
| Claims        | Claim Processing               | Claims Service       |
| Payments      | Premium Collection             | Payment Service      |
| Notifications | Email & Alerts                 | Notification Service |
| Audit         | Activity Tracking              | Audit Service        |

---

# 4. Core Business Entities

## 4.1 Customer

### Purpose

Represents a person who registers with InsuranceHub to purchase and manage health insurance policies.

### Owned By

Customer Service

### Key Attributes

* Customer ID
* First Name
* Middle Name
* Last Name
* Date of Birth
* Gender
* Email Address
* Mobile Number
* Aadhaar Number
* PAN Number
* Occupation
* Annual Income
* Customer Status
* Registration Date

### Relationships

* A Customer belongs to one Branch.
* A Customer may be assigned to one Agent.
* A Customer can submit many Policy Applications.
* A Customer can own many Policies.
* A Customer can upload many Documents.

### Business Rules

* Email address must be unique.
* Mobile number must be unique.
* Customer must complete KYC before purchasing a policy.
* Only ACTIVE customers may submit policy applications.

### Domain Events

* CustomerRegistered
* CustomerProfileUpdated
* CustomerKYCSubmitted
* CustomerApproved

---

## 4.2 Branch

### Purpose

Represents a physical InsuranceHub office responsible for serving customers and managing insurance operations.

### Owned By

Customer Service

### Key Attributes

* Branch ID
* Branch Name
* City
* State
* Address
* Contact Number
* Branch Manager

### Relationships

* One Branch serves many Customers.
* One Branch employs many Agents.

### Business Rules

* Every Customer must belong to one Branch.
* Every Agent must belong to one Branch.

---

## 4.3 Agent

### Purpose

Represents an insurance advisor responsible for assisting customers with policy applications and KYC verification.

### Owned By

Customer Service

### Key Attributes

* Agent ID
* Employee ID
* Full Name
* Email
* Mobile Number
* License Number
* Years of Experience
* Employment Status

### Relationships

* One Agent belongs to one Branch.
* One Agent manages many Customers.

### Business Rules

* Only ACTIVE agents may verify KYC.
* Agent license number must be unique.

---

# 5. Relationship Summary

| Parent   | Relationship | Child              |
| -------- | ------------ | ------------------ |
| Branch   | 1 → Many     | Customer           |
| Branch   | 1 → Many     | Agent              |
| Agent    | 1 → Many     | Customer           |
| Customer | 1 → Many     | Policy Application |
| Customer | 1 → Many     | Policy             |
| Customer | 1 → Many     | Document           |

---

# 6. Domain Events (Initial)

| Event                      | Description                              |
| -------------------------- | ---------------------------------------- |
| CustomerRegistered         | A new customer account has been created. |
| CustomerApproved           | Customer KYC has been approved.          |
| PolicyApplicationSubmitted | Customer submitted a policy application. |
| PolicyIssued               | Policy has been approved and issued.     |
| PremiumPaid                | Premium payment completed successfully.  |
| ClaimSubmitted             | Customer submitted an insurance claim.   |
| ClaimApproved              | Claim approved for settlement.           |

---

# 7. Future Expansion

The following entities will be added in subsequent revisions:

* User
* Role
* Insurance Plan
* Policy Application
* Policy
* Payment
* Claim
* Document
* Notification
* Audit Log
* Session
* Address

---

# Document Status

**Status:** Draft v1.0

This document will evolve as new business capabilities and microservices are introduced into InsuranceHub.
