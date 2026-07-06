# InsuranceHub Platform - Use Cases

## Document Information

| Attribute     | Value     |
| ------------- | --------- |
| Document Name | Use Cases |
| Version       | 1.0       |
| Status        | Approved  |
| Last Updated  | July 2026 |

---

# 1. Purpose

This document defines the primary business use cases supported by the InsuranceHub Platform MVP. Each use case describes how an actor interacts with the system to achieve a business goal.

---

# 2. Actors

| Actor                | Description                                                         |
| -------------------- | ------------------------------------------------------------------- |
| Customer             | Purchases and manages health insurance policies.                    |
| Agent                | Assists customers with onboarding, KYC, and policy-related queries. |
| Branch Manager       | Reviews and approves insurance claims.                              |
| System Administrator | Manages users, plans, branches, and system configuration.           |
| Notification Service | Sends emails and WhatsApp notifications.                            |

---

# UC-01 Customer Registration

### Primary Actor

Customer

### Preconditions

* Customer is not already registered.
* Aadhaar and PAN are available.

### Main Flow

1. Customer registers using email and password.
2. System validates uniqueness.
3. Customer account is created.
4. Audit log is recorded.
5. Welcome notification is sent.

### Alternate Flow

* Email already exists → Registration rejected.

### Postconditions

* Customer account is created.
* Customer can log in.

---

# UC-02 Customer Login

### Primary Actor

Customer

### Preconditions

* Customer account exists.
* Account is active.

### Main Flow

1. Customer enters credentials.
2. Identity Service validates credentials.
3. JWT access token is generated.
4. Login audit event is recorded.

### Alternate Flow

* Invalid credentials.
* Account locked.

### Postconditions

* Customer is authenticated.

---

# UC-03 Submit KYC

### Primary Actor

Customer

### Preconditions

* Customer is logged in.

### Main Flow

1. Upload Aadhaar.
2. Upload PAN.
3. Submit KYC request.
4. Customer Service validates documents.
5. KYC status becomes **Pending**.

### Alternate Flow

* Missing documents.
* Invalid file format.

### Postconditions

* KYC request is stored.

---

# UC-04 Approve KYC

### Primary Actor

System Administrator

### Preconditions

* KYC status is Pending.

### Main Flow

1. Review submitted documents.
2. Approve or reject KYC.
3. Customer is notified.
4. Audit log is created.

### Postconditions

* KYC status updated.

---

# UC-05 Purchase Policy

### Primary Actor

Customer

### Preconditions

* Customer is logged in.
* KYC is Approved.
* No active duplicate policy for the selected plan.

### Main Flow

1. Browse available plans.
2. Select a plan.
3. Review premium.
4. Proceed to payment.
5. Payment succeeds.
6. Policy is issued.
7. Notification is sent.
8. Audit entry is created.

### Alternate Flow

* Payment fails.
* KYC not approved.
* Duplicate policy exists.

### Postconditions

* Policy becomes Active.

---

# UC-06 Pay Premium

### Primary Actor

Customer

### Preconditions

* Active policy exists.

### Main Flow

1. Customer selects policy.
2. Pays premium.
3. Payment is recorded.
4. Policy Service receives payment event.
5. Notification is sent.
6. Audit log is created.

### Alternate Flow

* Payment failure.
* Payment timeout.

### Postconditions

* Premium recorded successfully.

---

# UC-07 Submit Claim

### Primary Actor

Customer

### Preconditions

* Policy is Active.

### Main Flow

1. Customer selects policy.
2. Uploads claim documents.
3. Enters claim amount.
4. Submits claim.
5. Claim status becomes **Submitted**.
6. Branch Manager is notified.

### Alternate Flow

* Claim amount exceeds insured amount.
* Required documents missing.

### Postconditions

* Claim enters review process.

---

# UC-08 Approve Claim

### Primary Actor

Branch Manager

### Preconditions

* Claim status is Submitted.

### Main Flow

1. Review documents.
2. Verify policy validity.
3. Approve or reject claim.
4. Customer receives notification.
5. Audit log updated.

### Alternate Flow

* Additional documents requested.
* Claim rejected.

### Postconditions

* Claim status updated.

---

# UC-09 Renew Policy

### Primary Actor

Customer

### Preconditions

* Policy is nearing expiry.

### Main Flow

1. Customer requests renewal.
2. Premium calculated.
3. Payment completed.
4. Policy expiry extended.
5. Notification sent.

### Alternate Flow

* Renewal after expiry → Late fee applies.

### Postconditions

* Policy renewed.

---

# UC-10 Cancel Policy

### Primary Actor

Customer

### Preconditions

* Active policy exists.

### Main Flow

1. Customer requests cancellation.
2. System calculates refundable premium according to business rules.
3. Customer confirms cancellation.
4. Policy status changes to Cancelled.
5. Refund is initiated (if applicable).
6. Notification sent.
7. Audit log recorded.

### Alternate Flow

* Refund not applicable due to policy conditions.

### Postconditions

* Policy cancelled.

---

# 3. Use Case Traceability

| Use Case | Related Context                                |
| -------- | ---------------------------------------------- |
| UC-01    | Identity, Customer                             |
| UC-02    | Identity                                       |
| UC-03    | Customer                                       |
| UC-04    | Customer                                       |
| UC-05    | Customer, Policy, Payment, Notification, Audit |
| UC-06    | Payment, Policy                                |
| UC-07    | Claims                                         |
| UC-08    | Claims                                         |
| UC-09    | Policy, Payment                                |
| UC-10    | Policy, Payment                                |
