# InsuranceHub

# Domain Dictionary

| **Document Information** |                          |
| ------------------------ | ------------------------ |
| **Document ID**          | INS-DOM-002              |
| **Project Name**         | InsuranceHub             |
| **Version**              | 1.0                      |
| **Status**               | Draft                    |
| **Author**               | Subhojeet Ghosh          |
| **Reviewer**             | Ace (Solution Architect) |

---

# 1. Purpose

The Domain Dictionary provides a common business vocabulary for InsuranceHub. It ensures that business users, developers, testers, architects, and operations teams use consistent terminology throughout the project.

---

# 2. Business Terms

| Term               | Definition                                                                                             |
| ------------------ | ------------------------------------------------------------------------------------------------------ |
| Customer           | A registered individual who purchases or manages one or more health insurance policies.                |
| User               | Any authenticated person who can access InsuranceHub (Customer, Agent, Branch Manager, Administrator). |
| Agent              | Insurance representative responsible for customer onboarding and KYC verification.                     |
| Branch             | A physical InsuranceHub office responsible for customer servicing.                                     |
| Insurance Plan     | A health insurance product offered by InsuranceHub (e.g., Basic Care, Family Shield, Premium Protect). |
| Policy Application | A customer's request to purchase an insurance plan. This exists before policy approval.                |
| Policy             | The approved insurance contract issued after successful application review.                            |
| Premium            | The amount paid periodically by a customer to keep a policy active.                                    |
| Claim              | A request submitted by a customer to receive benefits under an active policy.                          |
| Claim Settlement   | The final outcome of a claim after approval or rejection.                                              |
| KYC                | Know Your Customer verification process using government-issued identity documents.                    |
| Document           | Any uploaded file such as Aadhaar, PAN, medical reports, or claim evidence.                            |
| Notification       | A message sent to users through email or future communication channels.                                |
| Session            | An authenticated login session for a user.                                                             |
| Role               | Defines the permissions assigned to a user within the system.                                          |
| Audit Log          | A record of significant business or security events for compliance and traceability.                   |

---

# 3. Business Status Definitions

## Customer Status

* Registered
* KYC Pending
* KYC Verified
* Active
* Suspended
* Inactive

---

## Policy Application Status

* Draft
* Submitted
* Under Review
* Approved
* Rejected

---

## Policy Status

* Active
* Expired
* Cancelled
* Suspended

---

## Claim Status

* Submitted
* Under Review
* Approved
* Rejected
* Settled

---

## Payment Status

* Pending
* Successful
* Failed
* Refunded

---

# 4. Abbreviations

| Abbreviation | Meaning                           |
| ------------ | --------------------------------- |
| API          | Application Programming Interface |
| JWT          | JSON Web Token                    |
| KYC          | Know Your Customer                |
| MFA          | Multi-Factor Authentication       |
| UI           | User Interface                    |
| DB           | Database                          |
| ERD          | Entity Relationship Diagram       |
| ADR          | Architecture Decision Record      |
| HLD          | High-Level Design                 |
| LLD          | Low-Level Design                  |

---

# 5. Naming Standards

* Entity names use singular form (Customer, Policy, Claim).
* API endpoints use plural nouns (e.g., /customers, /policies).
* Status values use PascalCase (e.g., UnderReview, KYCVerified).
* Business events use past tense (e.g., CustomerRegistered, PolicyIssued, ClaimApproved).

---

# 6. Version History

| Version | Date        | Description                               |
| ------- | ----------- | ----------------------------------------- |
| 1.0     | 04-Jul-2026 | Initial version of the Domain Dictionary. |
