# InsuranceHub

# Business Rules

| **Document Information** |                          |
| ------------------------ | ------------------------ |
| **Document ID**          | INS-DOM-003              |
| **Project Name**         | InsuranceHub             |
| **Version**              | 1.0                      |
| **Status**               | Draft                    |
| **Author**               | Subhojeet Ghosh          |
| **Reviewer**             | Ace (Solution Architect) |

---

# 1. Purpose

This document defines the mandatory business rules that govern the operation of InsuranceHub. These rules ensure consistency, regulatory compliance, customer trust, operational efficiency, and fraud prevention. Every module of the system must enforce these rules.

---

# 2. Customer Management Rules

### BR-001 – Unique Customer Account

A customer shall have only one InsuranceHub account. Duplicate customer accounts are not permitted.

---

### BR-002 – Mandatory KYC Before Policy Issuance

A policy shall not be issued unless the customer's KYC has been successfully verified and approved.

Customers may begin the policy application process before KYC approval, but the policy cannot be issued until verification is complete.

---

### BR-003 – Mandatory Identity Verification

Every customer shall complete Aadhaar and PAN verification before the account is activated for insurance transactions.

---

### BR-004 – Assigned Agent

Every customer shall be assigned one primary Agent who will act as the customer's primary point of contact throughout the policy lifecycle.

---

# 3. Policy Management Rules

### BR-005 – Policy Issuance

Only verified customers with approved KYC are eligible for policy issuance.

---

### BR-006 – Policy Cancellation

Customers may request policy cancellation at any time.

Refund eligibility shall be determined based on:

* Free-look period
* Premium payment history
* Claim history
* Applicable company policies
* Regulatory guidelines

---

### BR-007 – Policy Renewal

Customers should renew their policies before the expiry date.

Late renewals may result in:

* Penalty charges
* Waiting periods
* Fresh underwriting (if applicable)

---

### BR-008 – Multiple Policies

A customer may own multiple active insurance policies provided they represent different insurance plans.

Duplicate active policies of the same insurance plan are not permitted unless specifically allowed by company policy.

---

# 4. Premium & Payment Rules

### BR-009 – Premium Due Date

Premium payments must be completed on or before the due date.

---

### BR-010 – Defaulter Management

Customers who fail to pay premiums after the allowed grace period shall be classified as Defaulters.

The system shall maintain a Defaulter List for operational monitoring.

---

# 5. Claim Management Rules

### BR-011 – Claim Eligibility

Claims may only be submitted against active insurance policies.

---

### BR-012 – Claim Approval Workflow

Claims shall undergo operational review before final approval.

Final approval authority rests with the Branch Manager.

---

### BR-013 – Claim Settlement Limit

The approved claim amount shall never exceed the insured coverage amount.

Claim settlement shall also consider:

* Co-payment
* Deductibles
* Waiting periods
* Policy exclusions
* Coverage limits

---

# 6. Agent & Branch Rules

### BR-014 – Agent Responsibility

Agents are responsible for:

* Customer onboarding
* KYC assistance
* Document collection
* Policy guidance
* Claim assistance
* Customer communication

---

### BR-015 – Agent Data Access

Agents shall have access only to customers assigned to them.

Access to customers belonging to other agents is prohibited.

---

### BR-016 – Branch Monitoring

Branch Managers shall monitor Agent activities through dashboards, reports, and audit logs to ensure compliance and detect fraudulent activities.

---

# 7. Security & Compliance Rules

### BR-017 – Fraud Prevention

InsuranceHub shall implement fraud detection and verification mechanisms while ensuring genuine customers are treated fairly.

---

### BR-018 – Audit Trail

Every critical business activity shall be recorded in an immutable audit log.

Examples include:

* Customer registration
* KYC approval/rejection
* Policy issuance
* Premium payment
* Claim approval/rejection
* Policy cancellation

---

### BR-019 – Role-Based Access Control

Users shall only access information and perform actions permitted by their assigned roles.

---

# 8. Customer Experience Rules

### BR-020 – Customer-Friendly Journey

InsuranceHub shall provide a simple, transparent, and guided customer experience throughout the insurance lifecycle.

Customers should always be informed of:

* Application status
* KYC status
* Policy status
* Premium due dates
* Claim status

---

# 9. Future Business Rules

The following rules are planned for future releases:

* Nominee Management
* Family Floater Policies
* Cashless Hospital Network
* Wellness Reward Program
* No Claim Bonus (NCB)
* AI-based Fraud Detection
* Risk Scoring
* Digital Health Records
* Auto Policy Renewal
* Multi-Branch Transfers

---

# 10. Version History

| Version | Date        | Description                        |
| ------- | ----------- | ---------------------------------- |
| 1.0     | 05-Jul-2026 | Initial version of Business Rules. |
