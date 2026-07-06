# InsuranceHub Platform - Bounded Contexts

## Document Information

| Attribute     | Value                 |
| ------------- | --------------------- |
| Document Name | Bounded Contexts      |
| Version       | 1.0                   |
| Status        | Approved              |
| Owner         | Solution Architecture |
| Last Updated  | July 2026             |

---

# 1. Purpose

The purpose of this document is to define the business boundaries of the InsuranceHub Platform using Domain-Driven Design (DDD) principles.

Each bounded context represents a distinct business capability with clear ownership of its data, business rules, and APIs. This separation minimizes coupling between services and improves maintainability, scalability, and security.

---

# 2. Bounded Context Overview

| Context              | Primary Responsibility                                                |
| -------------------- | --------------------------------------------------------------------- |
| Identity Context     | Authentication, authorization, user accounts, and role management     |
| Customer Context     | Customer profile, KYC, Aadhaar/PAN verification, and agent assignment |
| Policy Context       | Insurance plans, policy lifecycle, renewals, and cancellations        |
| Payment Context      | Premium collection, payment history, refunds, and defaulters          |
| Claims Context       | Claim submission, document verification, and claim approval workflow  |
| Notification Context | Email, WhatsApp, and future notification channels                     |
| Audit Context        | Audit logs, compliance records, and security event tracking           |

---

# 3. Context Details

## 3.1 Identity Context

### Responsibilities

* User registration
* User authentication
* JWT token generation
* Password management
* Role management
* Session validation

### Owns

* User Account
* Credentials
* Roles
* Authentication Tokens

### Does Not Own

* Customer Profile
* Policies
* Payments
* Claims

---

## 3.2 Customer Context

### Responsibilities

* Customer profile management
* KYC processing
* Aadhaar verification
* PAN verification
* Agent assignment
* Contact information

### Owns

* Customer Profile
* KYC Status
* Verification Details
* Assigned Agent

### Does Not Own

* Login credentials
* Policies
* Claims
* Payments

---

## 3.3 Policy Context

### Responsibilities

* Health insurance plans
* Policy purchase
* Policy issuance
* Policy renewal
* Policy cancellation
* Policy status management

### Owns

* Insurance Plans
* Customer Policies
* Policy Lifecycle

### Does Not Own

* Premium collection
* Claims
* Customer KYC

---

## 3.4 Payment Context

### Responsibilities

* Premium payment
* Payment history
* Refund processing
* Defaulter tracking
* Payment validation

### Owns

* Payment Records
* Premium Transactions
* Refund History

### Does Not Own

* Policy activation rules
* Customer profile
* Claims

---

## 3.5 Claims Context

### Responsibilities

* Claim submission
* Claim document management
* Claim verification
* Branch manager approval
* Claim settlement status

### Owns

* Claims
* Claim Documents
* Claim Status

### Does Not Own

* Premium payments
* Authentication
* Customer profile

---

## 3.6 Notification Context

### Responsibilities

* Email notifications
* WhatsApp notifications
* Notification templates
* Delivery tracking

### Owns

* Notification Requests
* Delivery Status
* Templates

### Does Not Own

* Business decisions
* Customer policies
* Payments

---

## 3.7 Audit Context

### Responsibilities

* Audit logging
* Compliance records
* Security event tracking
* User activity history

### Owns

* Audit Logs
* Activity Records
* Security Logs

### Does Not Own

* Customer business data
* Policies
* Payments

---

# 4. Context Communication

The InsuranceHub Platform follows an event-driven communication model wherever practical.

Examples include:

| Event               | Publisher        | Subscribers                 |
| ------------------- | ---------------- | --------------------------- |
| Customer Registered | Customer Context | Notification, Audit         |
| KYC Approved        | Customer Context | Policy, Audit               |
| Premium Paid        | Payment Context  | Policy, Notification, Audit |
| Policy Issued       | Policy Context   | Notification, Audit         |
| Claim Submitted     | Claims Context   | Notification, Audit         |
| Claim Approved      | Claims Context   | Notification, Audit         |

---

# 5. Context Ownership Principles

The following principles apply to every bounded context:

* A bounded context owns its own business logic.
* A bounded context owns its own APIs.
* A bounded context is the source of truth for its data.
* Other contexts must not directly modify its business data.
* Communication between contexts should occur through APIs or domain events.

---

# 6. Benefits of This Design

This bounded context design provides:

* Clear ownership of business capabilities.
* Reduced coupling between services.
* Easier maintenance and future enhancements.
* Improved scalability.
* Better security through responsibility separation.
* Easier migration to independent microservices.

---

# 7. Future Considerations

As InsuranceHub evolves, additional bounded contexts may be introduced for:

* Fraud Detection
* Reporting & Analytics
* Billing
* Document Management
* Customer Support
* Partner Integrations

These contexts are outside the scope of the MVP and will be evaluated in future releases.
